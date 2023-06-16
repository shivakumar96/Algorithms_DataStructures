package com.shivakumar.algorithms.leetcode;

public class BSTSuccessor {
    public static class TreeNode {
        int val;
        BSTSuccessor.TreeNode left;
        BSTSuccessor.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Time complexity O(N);
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successorNode = null ;

        while(root != null){
            if(p.val>=root.val ){
                root = root.right;
            }else{
                successorNode = root;
                root = root.left;
            }
        }

        return successorNode;
    }

}
