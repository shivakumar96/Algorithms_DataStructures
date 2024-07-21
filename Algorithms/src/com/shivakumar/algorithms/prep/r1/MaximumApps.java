package com.shivakumar.algorithms.prep.r1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given Memory M and a list of N apps with download and install memory calculate the
 * Maximum number of apps that can be installed
 *
 * Apps = {
 *             { D:10, S:15 }, //{Download memory and actual memory}
 *             { D:3,  S:5 }
 *             { D:3, S:3}
 *           }
 *
 *  1) given two apps which one to install first.
 *      (di,si),(dj,sj)
 *      si+dj < sj+di
 *   => (si-di)<(sj-dj), which means and app with less value of (si-di) will be installed first.
 *
 *   solution is using backtrack + sort
 *
 *   let apps = [[10,15],[3,5],[3,3]]
 *
 */
public class MaximumApps {
    private int[][] dp;
    private int itrCount;
    public int backtrack(int apps[][], Set<Integer> selectedApps, int currMem, int count){
        if(currMem<=0)
            return count;
        int res = count;
        itrCount++;
        for(int i=0;i<apps.length;i++){
            if(!selectedApps.contains(i) && (currMem - Math.max(apps[i][0], apps[i][1]))>=0){
                selectedApps.add(i);
                res = Math.max(res,backtrack(apps,selectedApps,currMem-apps[i][1],count+1));
                selectedApps.remove(i);
            }
        }
        return res;
    }

    // optimized
    //before this Sort them as  Arrays.sort(apps, (a,b)->((a[1]-a[0])-(b[1]-b[0])));
    public int backtrack2(int apps[][], int indx, int currMem, int count){
        if(currMem<=0)
            return count;
        itrCount++;
        //System.out.println(indx+" : "+currMem);
        int res = count;
        for(int i=indx;i<apps.length;i++){
            if( (currMem - Math.max(apps[i][0], apps[i][1]))>=0){
                res = Math.max(res,backtrack2(apps,i+1,currMem-apps[i][1],count+1));
            }
        }
        return  res;
    }

    //We can apply dp;
    // optimized
    //before this Sort them as  Arrays.sort(apps, (a,b)->((a[1]-a[0])-(b[1]-b[0])));
    //dp[n+1][memory] = it can be dp of bit mask
    public int backtrack3(int apps[][], int indx, int currMem, int count){
        if(currMem<=0)
            return count;

        if(dp[indx][currMem] != -1){
            return dp[indx][currMem];
        }

        itrCount++;
        int res = count;
        for(int i=indx;i<apps.length;i++){
            if( (currMem - Math.max(apps[i][0], apps[i][1]))>=0){
                res = Math.max(res,backtrack3(apps,i+1,currMem-apps[i][1],count+1));
            }
        }
        return dp[indx][currMem] = res;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{2,3},{1,2},{4,3},{2,2},{1,3},{2,5}};
        int[][] arr2 = new int[][]{{2,3},{1,2},{4,3}};
        int[][] arr3 = new int[][]{{2,3},{1,2},{4,3}};
        int[][] arr4 = new int[][]{{2,3},{1,2},{4,3}};
        int[][] arr5 = new int[][]{{2,3},{1,2},{4,3}};

        MaximumApps apps = new MaximumApps();
        int maxMem =10;
        apps.dp = new int[(arr1.length+1)][maxMem+1];
        for(int[] row: apps.dp)
                Arrays.fill(row,-1);
        apps.itrCount=0;
        System.out.println(apps.backtrack(arr1,new HashSet<>(),maxMem,0));
        System.out.println("iter count: "+apps.itrCount);
        apps.itrCount=0;
        Arrays.sort(arr1,(a,b)->(a[1]-a[0])-(b[1]-b[0]));
        System.out.println(arr1[0][0]+" , "+arr1[0][1]);
        System.out.println(apps.backtrack2 (arr1,0,maxMem,0));
        System.out.println("iter count: "+apps.itrCount);
        apps.itrCount=0;
        System.out.println(apps.backtrack3 (arr1,0,maxMem,0));
        System.out.println("iter count: "+apps.itrCount);


    }

}
