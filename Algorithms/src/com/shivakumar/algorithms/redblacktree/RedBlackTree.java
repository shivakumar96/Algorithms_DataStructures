package com.shivakumar.algorithms.redblacktree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *     RED BLACK TREE Properties
 *     1. EVery Node is either red or black
 *     2. The nil/null/None node is considered as leaves of tree, and every nil-leaf is a black node
 *     3. The root is black
 *     4. If a node is red then both its children are black
 *     5. FOr each node, all paths from the node to descendant leaves contain same number of black nodes
 *     /--------------------------------------
 *     //Insert algorithm, pseudo code. source = {@link <a href="https://www.youtube.com/watch?v=aPqz3jyl8ak">...</a>}
 *     // z = current node, p[z] = parent;
 *     // While z != Root || color[p[z]] == red{
 *     //  do if p[z] == left[p[p[z]]
 *     //      then y = right[p[p[z]]
 *     //          case 1: y is red
 *     //              color p[z] and y black, p[p[z]] red
 *     //                  z = p[p[z]]
 *     //      else "symmetric case" y is black
 *     //          case 2: z == right
 *     //                  left rotation on a= p[z]
 *     //          case 3: a == left[p[a]]
 *     //                  right rotation on b = p[a] + recolor
 *     // }
 */



enum TreeColor{
    RED,
    BLACK
}

class Node<K extends Comparable<K>, V>{
    K key;
    V value;

    TreeColor color;
    Node<K,V> left,right,parent;

    Node(K key, V value){
        this.key = key;
        this.value = value;
        color = TreeColor.RED;
        left = null;
        right = null;
        parent = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", color=" + color +
                ", hashcode=" + hashCode()+
                ", parent=" + (parent==null?"null ":parent.hashCode()) +
                '}';
    }
}


public class RedBlackTree<K extends Comparable<K>, V> {
    Node<K,V> root ;
    RedBlackTree(){
        root = null;
    }

    private void leftRotation(Node<K,V> node){

        // node and node.right will never be empty in left rotation
        Node<K,V> newRoot = node.right;
        Node<K,V> oldLeft = newRoot.left;
        Node<K, V> newRootParent = node.parent;

        // updating children
        newRoot.left = node;
        node.right = oldLeft;

        //updating parents
        node.parent = newRoot;
        if(oldLeft != null) oldLeft.parent = node;
        newRoot.parent = newRootParent;

        adjustChildNode(newRootParent,node,newRoot);
    }

    private void rightRotation(Node<K,V> node){
        Node<K,V> newRoot = node.left;
        Node<K,V> oldRight = newRoot.right;
        Node<K, V> newRootParent = node.parent;

        // updating children
        newRoot.right = node;
        node.left = oldRight;

        //updating parents
        node.parent = newRoot;
        if(oldRight != null) oldRight.parent = node;
        newRoot.parent = newRootParent;

        adjustChildNode(newRootParent,node,newRoot);
    }

    private void adjustChildNode(Node<K,V> parent, Node<K,V> oldChild, Node<K,V> newChild){
        if(parent == null){
            this.root = newChild;
            System.out.println(root);
        }
        else if(parent.left == oldChild){
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        }else {
            System.err.println("Illegal reference");
        }
    }

    public void insert(K key, V val){

        //new child node
        Node<K,V> node =  new Node<>(key,val);

        // if root is null th
        if(root == null){
            root = node;
            root.color = TreeColor.BLACK;
            return;
        }

        Node<K,V> curr = root;
        Node<K,V> parent = null;
        // go to the respective parent node
        while (curr != null){
            parent = curr;
            if(curr.key !=null && curr.key.compareTo(key) <0) {
                curr = curr.right;
            }
            else if (curr.key != null && curr.key.compareTo(key)>0) {
                curr =curr.left;
            } else {
                System.err.println("Error");
            }
        }
        System.out.println(parent);

        // add the child to respective parent node
        if(parent.key.compareTo(key)<0)
            parent.right = node;
        else
            parent.left = node;

        //update parent;
        node.parent = parent;


        //fix the properties if violated.
        fixInsertWithRotation(node);
    }


    private void fixInsertWithRotation(Node<K,V> node){


        // Referring to the above algorithm
        // since this will be called only when there is at least root,
        // this implies parentZ will not be null initially
        Node<K,V> parentZ =  node.parent;
        Node<K,V> nodeZ = node;
        while ( nodeZ != root && parentZ.color.equals(TreeColor.RED)){
            Node<K,V> grandParent = parentZ.parent ;
            Node<K,V> y = grandParent.right != parentZ? grandParent.right : grandParent.left;

            if(y != null && y.color.equals(TreeColor.RED)){
                y.color = TreeColor.BLACK;
                parentZ.color = TreeColor.BLACK;
                grandParent.color = TreeColor.RED;
                nodeZ = grandParent;
            }
            else if(parentZ == grandParent.left){
                if(nodeZ == parentZ.right){
                    leftRotation(parentZ);
                    // when you rotate the parent changes
                    parentZ = nodeZ;

                }
                rightRotation(grandParent);
                parentZ.color = TreeColor.BLACK;
                grandParent.color =TreeColor.RED;
            } else {
                if(nodeZ == parentZ.left){
                    rightRotation(parentZ);
                    // when you rotate the parent changes
                    parentZ = nodeZ;
                }
                leftRotation(grandParent);
                parentZ.color = TreeColor.BLACK;
                grandParent.color =TreeColor.RED;
            }

        }

        root.color = TreeColor.BLACK;


    }

    private void printTreeLevelOrder(){
        if(root == null)
            return;
        Queue<Node<K,V>> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                Node<K,V> node = queue.poll();
                if(node == null)
                    continue;
                System.out.println(node);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;
            }
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer,String> tree = new RedBlackTree<>();
        tree.insert(6,"a");
        tree.printTreeLevelOrder();
        System.out.println("\nEnd\n");

        tree.insert(4,"a");
        tree.insert(8,"a");
        //tree.printTreeLevelOrder();
        System.out.println("\nEnd\n");

        tree.insert(5,"a");
        //tree.printTreeLevelOrder();
        System.out.println();

        tree.insert(10,"a");
        tree.printTreeLevelOrder();
        System.out.println();

        tree.insert(12,"a");
        tree.printTreeLevelOrder();
        System.out.println();

        tree.insert(15,"a");
        tree.printTreeLevelOrder();
        System.out.println();


//        tree.insert(6,"a");
//        tree.printTreeLevelOrder();
//        System.out.println("\nEnd\n");
//
//        tree.insert(4,"a");
//        tree.insert(5,"a");
//        tree.printTreeLevelOrder();
//        System.out.println("\nEnd\n");




    }


}
