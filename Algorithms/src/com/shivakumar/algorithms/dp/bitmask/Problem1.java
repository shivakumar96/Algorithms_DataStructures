package com.shivakumar.algorithms.dp.bitmask;

/*
Source: https://youtu.be/685x-rzOIlY?si=8qBze2QtpLKIlM5g
Problem Statement
Let there be N workers and N jobs. Any worker can be assigned to perform any job, incurring some cost that may vary depending on the work-job assignment. It is required to perform all jobs by assigning exactly one worker to each job and exactly one job to each agent in such a way that the total cost of the assignment is minimized.
Input Format
Number of workers and job: N
Cost matrix C with dimension N*N where C(i,j) is the cost incurred on assigning ith Person to jth Job.
Sample Input
4

{
{9, 2, 7, 8},
{6, 4, 3, 7},
{5, 8, 1, 8},
{7, 6, 9, 4},
}

Sample Output
13

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Backtrack
class DPSolution1{
    Set<Integer> assignedJobs ;
    int dfs(int person, int[][] costs ){
        if(person == costs.length)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<costs[0].length; i++){
            if(!assignedJobs.contains(i)){
                assignedJobs.add(i);
                res = Math.min(res,costs[person][i] + dfs(person+1,costs));
                assignedJobs.remove(i);
            }
        }
        return res;
    }

    public int solve(int[][] costs){
        assignedJobs = new HashSet<>();
        return dfs(0,costs);
    }
}

class BitmaskSolution{
    int dp[][];
    int backtrackDP(int person, int remainingJobs, int [][]costs){
        if(person == costs.length)
            return 0;
        if(dp[person][remainingJobs] != -1)
            return dp[person][remainingJobs];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<costs[0].length; i++){
            if( (remainingJobs&(1<<i) ) > 0){
                res = Math.min(res,costs[person][i] + backtrackDP(person+1,(remainingJobs^(1<<i) ),costs));
            }
        }

        return dp[person][remainingJobs] = res;
    }

    public int solve(int[][] costs){
        int mask=(1<<costs[0].length)-1;
        dp = new int[costs.length+1][mask+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return backtrackDP(0,mask,costs);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        DPSolution1 dps = new DPSolution1();
        int[][] costs = new int[][]{
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4},
        };
        BitmaskSolution solution = new BitmaskSolution();
        System.out.println(solution.solve(costs));
        System.out.println(dps.solve(costs));
    }
}
