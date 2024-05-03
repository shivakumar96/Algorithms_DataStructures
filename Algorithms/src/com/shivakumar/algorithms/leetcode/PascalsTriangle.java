package com.shivakumar.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        int resul =  1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> nextList = new ArrayList<>();
            resul =1;
            nextList.add(1);
            for (int j = 1; j < i; j++) {
                resul*=(i-j);
                resul/=(j);
                nextList.add(resul);
            }
            lists.add(nextList);
        }
        return lists;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(5));
    }

}
