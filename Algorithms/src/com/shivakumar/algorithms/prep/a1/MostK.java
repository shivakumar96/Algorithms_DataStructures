// Most seen IP address
package com.shivakumar.algorithms.prep.a1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class IPNode{
    IPNode next = null;
    IPNode prev = null;
    String ip;
    int count;
    IPNode(String ip){
        this.ip = ip;
        count =1;
    }
    IPNode(){
        count=0;
    }
}

class IPNodeDList {
    IPNode head, tail;
    int nodeCount;
    IPNodeDList(){
        head = new IPNode("Head");
        tail = new IPNode("tail");
        head.next = tail;
        tail.prev = head;
        nodeCount =0;
    }

    void remove(IPNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        nodeCount--;
    }

    void add(IPNode node){
        node.next = head.next ;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        nodeCount++;
    }

    void  removeLast(){
        if(tail.prev == head)
            return;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        nodeCount--;
    }

}

public class MostK {

    Map<Integer,IPNodeDList> fmap;
    Map<String,IPNode> nodeMap;

    int capacity;
    int minf ;
    MostK(int capacity){
        fmap = new HashMap<>();
        nodeMap = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }

    public void put(String ip){
        // present
        if(nodeMap.containsKey(ip)){
            IPNode node = nodeMap.get(ip);
            int count = node.count;
            fmap.get(count).remove(node);
            if(minf == count)
                minf++;
            count++;
            node.count++;
            IPNodeDList nextlist = fmap.computeIfAbsent(count,(k)-> new IPNodeDList());
            nextlist.add(node);
            return;
        }
        if(nodeMap.size() == capacity){
            // remove the lowest frequent element
            IPNodeDList list =  fmap.get(minf);
            list.removeLast();
            if(list.nodeCount == 0)
                    fmap.remove(minf);
        }
        minf =1;
        IPNodeDList nextlist = fmap.computeIfAbsent(1,(k)-> new IPNodeDList());
        nextlist.add(new IPNode(ip));

    }



    public List<String> getTopKIps(){

        return null;
    }

    public static void main(String[] args) {

    }
}

