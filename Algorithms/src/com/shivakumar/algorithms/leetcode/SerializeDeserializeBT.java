package com.shivakumar.algorithms.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder serialized = new StringBuilder("");

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node == null) {
                if(queue.size()==0)
                    serialized.append("#");
                else
                    serialized.append("#,");
                continue;
            }
            else
            if(queue.size()==0)
                serialized.append(node.val+",");
            else
                serialized.append(node.val+",");


            queue.add(node.left);
            queue.add(node.right);
        }

        return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        if(values.length==1) return null ;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.add(root);

        for(int i=1; i<values.length;i++){
            TreeNode node = queue.poll();

            // adding left child
            if(!values[i].equals("#")){
                node.left = new TreeNode(Integer.valueOf(values[i]));
                queue.add(node.left);
            }
            i++;

            // adding right child
            if(!values[i].equals("#")){
                node.right = new TreeNode(Integer.valueOf(values[i]));
                queue.add(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeBT sd = new SerializeDeserializeBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String s = sd.serialize(root);
        System.out.println(s);
        TreeNode d = sd.deserialize(s);
        System.out.println(root.val + " "+ root.left.val+ " "+ root.right.val);

    }

}