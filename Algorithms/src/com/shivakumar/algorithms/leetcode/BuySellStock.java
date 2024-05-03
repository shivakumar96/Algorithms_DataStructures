package com.shivakumar.algorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BuySellStock {

    public int getProfit(int[] prices ){
        int profit=Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length;i++){
            if(minPrice >prices[i])
                minPrice = prices[i];
            profit = Math.max(profit,(prices[i]-minPrice));
        }
        return profit;
    }

    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        int[] prices = new int[]{7,1,5,3,6,4};
        int profit = buySellStock.getProfit(prices);
        //Arrays.sort(prices, Comparator.reverseOrder())
        System.out.println(profit);
    }
}
