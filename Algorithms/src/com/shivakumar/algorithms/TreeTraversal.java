package com.shivakumar.algorithms;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        return "{ "+this.val+" }";
    }
}

public class TreeTraversal {
    Stack<TreeNode> stack;

    void inorderTraversal(TreeNode root){
        stack = new Stack<>();
        TreeNode curr = root;
        System.out.println(stack);
        while (!stack.isEmpty() || curr != null){
            while( curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            System.out.println(stack);
            curr = stack.pop();
            System.out.println(curr);
            curr = curr.right;
        }
    }

    void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);

        TreeTraversal traversal = new TreeTraversal();
        traversal.printBoundaryLeft(treeNode);
    }
}
