package com.shivakumar.algorithms.binarysearchtree;

import java.util.List;
import java.util.Map;

public interface Tree<K extends Comparable<K> , V> {
    void insert(K key, V val);
    V search(K key);
    void delete(K key);
    boolean update(K key, V val);
    TreeNode<K,V> predecessor(K key);
    TreeNode<K,V> successor(K key);

    List<Map.Entry<K,V>> inorderTraversal();
}