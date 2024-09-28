package com.shivakumar.algorithms.avltree;
class Node <T extends Comparable> {
    T value;
    Node<T> left, right;

    int height;

    Node(T val){
        value = val;
        left = null; right = null;
        height =1;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", height=" + height +
                '}';
    }
}


public class AVLTree<T extends Comparable> {
    Node<T> root;
    AVLTree(){
        root = null;
    }

    void insert(T val){
        root = balancedInsert(root, val);
    }

    private int balanceFactor(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    private  int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    private Node<T> balancedInsert(Node<T> root, T key){
        if(root == null){
            return new Node<T>(key);
        }else if(root.value.compareTo(key) <0){
            root.right = balancedInsert(root.right,key);
        } else {
            root.left = balancedInsert(root.left,key);
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = balanceFactor(root);

        if (balance >1){
            if(root.left.value.compareTo(key) >0){
                root = rightRotation(root);
            } else {
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        }else if(balance <-1){
            if(root.right.value.compareTo(key) <0){
                root = leftRotation(root);
            } else {
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }

        }

        return  root;
    }

    private Node<T> leftRotation(Node<T> node){
        Node<T> newRoot = node.right ;
        Node<T> oldLeft = newRoot.left;

        newRoot.left = node;
        node.right = oldLeft;

        node.height = 1 + Math.max(height(node.left),height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left),height(newRoot.right));

        return newRoot;

    }

    private Node<T> rightRotation(Node<T> node){
        Node<T> newRoot = node.left;
        Node<T> oldRight = newRoot.right;

        newRoot.right = node;
        node.left = oldRight;

        node.height = 1 + Math.max(height(node.left),height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left),height(newRoot.right));

        return newRoot;
    }

    public void printTree(Node<T> root){
        if(root == null)
            return;
        printTree(root.left);
        System.out.println(root);
        System.out.println(balanceFactor(root));
        printTree(root.right);
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(4);
        avlTree.insert(6);


        avlTree.printTree(avlTree.root);
        System.out.println("--------");
        avlTree.insert(7);
        avlTree.printTree(avlTree.root);

    }

}
