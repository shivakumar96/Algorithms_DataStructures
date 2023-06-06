package com.shivakumar.algorithms.leetcode;

// solution for leetcode problem no: 1905. Count Sub Islands
// this make use of the same logic used for Number of Islands problem.

public class CountIslands {

    static boolean flag ;

    public static void main(String[] args) {

        int[][] grid1 = new int[][] {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = new int[][] {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};

        System.out.println(new CountIslands().countSubIslands(grid1,grid2));

    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int count =0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[i].length; j++){
                if(grid2[i][j] == 1){
                    flag = true;
                    checkwithDFS(grid1, grid2, i,j);
                    if(flag) count++;
                }
            }
        }

        return count;
    }

    public void checkwithDFS(int[][] grid1, int[][] grid2, int i, int j){

        if(i<0 || i>= grid2.length || j <0 || j>= grid2[i].length || grid2[i][j] == 0) return;

        if(grid1[i][j] == 0) { flag = false; return;}

        grid2[i][j] = 0 ;

        checkwithDFS(grid1, grid2, i+1,j); // down
        checkwithDFS(grid1, grid2, i-1,j); // up
        checkwithDFS(grid1, grid2, i,j+1); // right
        checkwithDFS(grid1, grid2, i,j-1); // left

    }

}
