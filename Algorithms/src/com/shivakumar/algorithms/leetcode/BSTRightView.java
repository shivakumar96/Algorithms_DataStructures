package com.shivakumar.algorithms.leetcode;


import java.util.ArrayList;
import java.util.List;

//leetcode 199: https://leetcode.com/problems/binary-tree-right-side-view/

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BSTRightView {
    public void getView(TreeNode root, int level, List<Integer> list){
        //Modified Preorder Root Right Left

        if(root == null) return;
        if(level == list.size()){
            list.add(root.val);
        }
        getView(root.right,level+1,list);
        getView(root.left,level+1,list);
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        getView(root,0,list);
        return list;
    }
}