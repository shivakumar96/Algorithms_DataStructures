import com.shivakumar.algorithms.leetcode.BSTSuccessor;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean isEnd;

    public TrieNode(){
        this.isEnd = false;
        children = new HashMap<>();
    }
}
class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void add(String s){
        char[] chs = s.toCharArray();
        TrieNode next = root;
        for(int i=0;i<chs.length;i++){
            if( !next.children.containsKey(chs[i])){
                next.children.put(chs[i],new TrieNode());
            }
            next = next.children.get(chs[i]);
        }
        next.isEnd = true;
    }


    public boolean delete(String s){

        return  false;
    }

    boolean search(String s){
        char[] chs = s.toCharArray();
        TrieNode next = root;
        for(int i =0; i<chs.length;i++){
            if(!next.children.containsKey(chs[i])){
                break;
            }
            next = next.children.get(chs[i]);
        }
        return next.isEnd;
    }
}


public class TrieImplematation {
    public static void main(String[] args) {
        Trie node = new Trie();
        node.add("hey");
        System.out.println(node.search("he"));
    }
}
