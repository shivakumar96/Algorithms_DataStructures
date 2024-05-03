package com.shivakumar.algorithms.leetcode;

//link: https://leetcode.com/problems/rotate-image/description/

import java.util.Arrays;
import java.util.Comparator;

public class RotateImage {

    public void rotate(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix.length;j++){
                int temp =  matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(matrix));
        rotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix));

    }
}
