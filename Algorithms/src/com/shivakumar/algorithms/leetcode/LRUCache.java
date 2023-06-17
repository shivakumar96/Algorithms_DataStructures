package com.shivakumar.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;


// LRUcache implementation
// leetcode 146. LRU Cache :

class LRUCache {
    class CacheDList{
        int keyV;
        int val;
        CacheDList next ;
        CacheDList prev;

        public CacheDList(int key, int value){
            val = value;
            keyV= key;
        }
    }
    // remove an element from the list;
    private void remove(CacheDList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // insert the elememt at head
    private void insertAtHead(CacheDList node, CacheDList head){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    Map<Integer,CacheDList> cache;
    int capacity;
    CacheDList head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new CacheDList(-1,-1);
        tail = new CacheDList(-1,-1);

        head.next = tail;
        tail.prev = head;

    }

    private void addkeytoLR(CacheDList node){
        remove(node);
        insertAtHead(node, head);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        CacheDList keyReference = cache.get(key);
        addkeytoLR(keyReference);
        return keyReference.val;
    }

    public void put(int key, int value) {
        CacheDList keyReference ;
        if(cache.containsKey(key)){
            keyReference = cache.get(key);
            keyReference.val = value;
            addkeytoLR(keyReference);
            return;
        }

        keyReference = new CacheDList(key, value);
        if(cache.size() == capacity){
            cache.remove(tail.prev.keyV);
            remove(tail.prev);
        }
        insertAtHead(keyReference, head);
        cache.put(key,keyReference);

        return;
    }

    public static void main(String[] args) {

    }
}