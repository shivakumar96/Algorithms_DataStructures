package com.shivakumar.algorithms.leetcode;

// leetcode 733. https://leetcode.com/problems/flood-fill/description/
class FloodFill {
    public void DFSFill(int[][] image, int i, int j, int color, int newColor){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return ;
        if(image[i][j] == color ) {
            image[i][j] = newColor;
            DFSFill(image,i+1,j,color,newColor); // down
            DFSFill(image,i,j+1,color,newColor); // right
            DFSFill(image,i-1,j,color,newColor); // up
            DFSFill(image,i,j-1,color,newColor); // left
        }


    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color)
            DFSFill(image,sr,sc,image[sr][sc],color);
        return image;
    }

    public static void main(String[] args) {

    }
}