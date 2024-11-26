package com.shivakumar.algorithms.prep.a1;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveBoxes {
    private int[][] memo;
    int count =0;

    private int removeMinBox(int start, int end, int[]arr, int cap){
        if(start>end)
            return 0;
        if(memo[start][end] !=-1)
            return memo[start][end];
        count++;
        if(arr[end]<=arr[start]*cap)
            return memo[start][end] = arr.length - (end -start)-1;
        return memo[start][end] = Math.min(removeMinBox(start+1,end,arr,cap),removeMinBox(start,end-1,arr,cap));
    }
    
    private int tabulation(int[]arr, int cap){
        int n = arr.length-1;
        int[][] dp = new int[n+1][n+1];
        Arrays.sort(arr);
        for(int[] row :dp)
            Arrays.fill(row,Integer.MAX_VALUE);

        for(int start=n;start>=0;start--){
            for(int end=start;end<=n;end++ ){
                if(arr[end]<=arr[start]*cap){
                    dp[start][end] =n-(end -start);
                }else {
                    dp[start][end] = Math.min(dp[start+1][end],dp[start][end-1]);
                }
            }
        }

        return dp[0][n];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,3,8,3,7};
        int cap =2;
        RemoveBoxes rb = new RemoveBoxes();
        Arrays.sort(arr);
        rb.memo = new int[arr.length+1][arr.length+1];
        for(int[] row :rb.memo)
            Arrays.fill(row,-1);
        int ans = rb.removeMinBox(0,arr.length-1,arr,cap);
        ans = rb.tabulation(arr,cap);
        System.out.println(ans);
        System.out.println("count="+rb.count);
    }
}
