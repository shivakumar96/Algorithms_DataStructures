package com.shivakumar.algorithms.binarysearchtree;

public class TreeNode<K extends Comparable<K> , V> {
    K key;
    V val;
    TreeNode left,right;

    TreeNode(K key, V val){
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}