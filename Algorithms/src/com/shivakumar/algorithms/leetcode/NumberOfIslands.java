package com.shivakumar.algorithms.leetcode;

// leetcode 200: number of island solution

public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = new char[][] { {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}  ;

        System.out.println(new NumberOfIslands().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int count =0;

        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[i].length; j++){
                if( grid[i][j] == '1' ){
                    count++;
                    discoverWithDFS(grid,i,j);
                }
            }
        }

        return count;

    }

    public void discoverWithDFS(char[][]grid, int i, int j){


        if(i<0 || i>=grid.length || j<0 || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        discoverWithDFS(grid,i-1,j); // up
        discoverWithDFS(grid,i+1,j); // down
        discoverWithDFS(grid,i,j+1); // right
        discoverWithDFS(grid,i,j-1); //left

    }
}
