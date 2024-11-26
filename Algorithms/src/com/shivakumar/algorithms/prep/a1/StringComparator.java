package com.shivakumar.algorithms.prep.a1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringComparator {
    private String[] getOrderedSting(int k, String letters, int n, String[] words ){
        Map<Character,Integer> level = new HashMap<>();
        char[] chars = letters.toCharArray();
        for (int i=0;i<chars.length;i++){
            level.put(chars[i],i);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i=0;
                while (i<s1.length() && i<s2.length()){
                    int l1 = level.get(s1.charAt(i));
                    int l2 = level.get(s2.charAt(i));
                    if( l1 < l2 )
                        return  -1;
                    if(l1 > l2 )
                        return  1;
                    i++;
                }
                if(i==s1.length() && i<s2.length())
                    return -1;
                if(i==s2.length() && i<s1.length())
                    return  1;

                return 0;
            }
        };
        Arrays.sort(words,comparator);
        return words;
    }

    public static void main(String[] args) {
        String s = "yYaAbBl";
        int k = s.length();
        String[] words = new String[]{"Yay", "yaY", "lyaB", "lyab", "b", "bay"};
        int n = words.length;
        StringComparator sc = new StringComparator();
        sc.getOrderedSting(k,s,n,words);
        for(String word : words){
            System.out.println(word);
        }
    }
}
