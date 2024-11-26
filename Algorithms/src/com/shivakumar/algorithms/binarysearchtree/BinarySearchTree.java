package com.shivakumar.algorithms.binarysearchtree;

import java.util.List;
import java.util.Map;

public class BinarySearchTree<K extends Comparable<K>,V> implements Tree<K,V>{
    private TreeNode Root;

    BinarySearchTree(){
        Root = null;
    }



    @Override
    public void insert(Comparable key, Object val) {

    }

    @Override
    public Object search(Comparable key) {
        return null;
    }

    @Override
    public void delete(Comparable key) {

    }

    @Override
    public boolean update(Comparable key, Object val) {
        return false;
    }

    @Override
    public TreeNode predecessor(Comparable key) {
        return null;
    }

    @Override
    public TreeNode successor(Comparable key) {
        return null;
    }

    @Override
    public List<Map.Entry<K, V>> inorderTraversal() {
        return null;
    }
}
