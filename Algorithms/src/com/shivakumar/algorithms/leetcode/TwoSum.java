package com.shivakumar.algorithms.leetcode;

//Problem No 1: https://leetcode.com/problems/two-sum/
public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        int first ;
        int count = 0 ;
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++){
            first = nums[i] ;
            for (int j = i+1; j < nums.length ; j++){
                if (first + nums[j] == target){
                    indices[count++] = i;
                    indices[count++] = j ;
                }
            }
        }

        return indices ;
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        // impletmation using hashmap
        return new int[1];
    }

    public static void main(String[] args) {

    }

}
