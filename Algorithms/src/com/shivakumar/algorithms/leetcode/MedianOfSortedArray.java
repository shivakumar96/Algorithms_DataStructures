package com.shivakumar.algorithms.leetcode;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        if(n1>n2)  findMedianSortedArrays(nums2,nums1);
        int left = (n1+n2+1)/2 ;
        int low=0, high = n1;
        int l1,l2,r1,r2,mid1,mid2;
        double result =0.0;

        while(low <= high ){
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;

            mid1 = (low + high) >>1;
            mid2 = left - mid1;

            if( mid1 < n1) r1 = nums1[mid1];
            if( mid2 < n2) r2 = nums2[mid2];
            if( mid1 >= 1) l1 = nums1[mid1-1];
            if( mid2 >= 1) l2 = nums2[mid2-1];

            if( l1 <= r2 && l2 <= r1){
                if(n%2==1) result = Math.max(l1,l2);
                else result = (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                break;
            } else if (l1>r2) high = mid1-1;
            else low = mid1 +1;
        }

        return result;
    }

    public static void main(String[] args) {
        MedianOfSortedArray median = new MedianOfSortedArray();
        int[] a = new int[]{2}, b = new int[0];
        System.out.println(median.findMedianSortedArrays(a,b));
    }
}
