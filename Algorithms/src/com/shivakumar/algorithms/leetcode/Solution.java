package com.shivakumar.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, Integer> prices;
    private Map<String, WorstTrade> worstTrades;

    public Solution() {
        this.prices = new HashMap<>();
        this.worstTrades = new HashMap<>();
    }

    public void ProcessTrade(int tradeId, String instrumentId, String buySell, int price, int volume) {
        Trade trade = new Trade(tradeId, instrumentId, buySell, price, volume);
        int pnlPerLot = trade.calculateProfitLoss(prices.getOrDefault(instrumentId, 0));

        WorstTrade currentWorstTrade = worstTrades.getOrDefault(instrumentId, null);
        if (currentWorstTrade == null || pnlPerLot < currentWorstTrade.pnlPerLot) {
            worstTrades.put(instrumentId, new WorstTrade(tradeId, pnlPerLot));
        }
    }

    public void ProcessPriceUpdate(String instrumentId, int price) {
        prices.put(instrumentId, price);
        WorstTrade currentWorstTrade = worstTrades.getOrDefault(instrumentId, null);
        if (currentWorstTrade != null) {
            int pnlPerLot = currentWorstTrade.pnlPerLot;
            WorstTrade updatedWorstTrade = new WorstTrade(currentWorstTrade.tradeId,
                    new Trade(currentWorstTrade.tradeId,
                            instrumentId,
                            "BUY",
                            price,
                            1).calculateProfitLoss(prices.getOrDefault(instrumentId, 0)));
            if (updatedWorstTrade.pnlPerLot > pnlPerLot) {
                worstTrades.put(instrumentId, updatedWorstTrade);
            }
        }
    }

    public int OutputWorstTrade(String instrumentId) {
        if (!worstTrades.containsKey(instrumentId)) {
            return -1;
        }
        return worstTrades.get(instrumentId).tradeId;
    }

    public static void main(String[] args) {
        Solution tradeAnalyzer = new Solution();

        // Sample input for custom testing:
        tradeAnalyzer.ProcessPriceUpdate("Facebook", 80);
        tradeAnalyzer.ProcessPriceUpdate("Apple", 120);
        tradeAnalyzer.ProcessTrade(100, "Apple", "SELL", 90, 2);
        tradeAnalyzer.ProcessTrade(10, "Facebook", "BUY", 100, 4);

        // Sample output for custom testing:
        System.out.println(tradeAnalyzer.OutputWorstTrade("Facebook")); // Output: 10
        System.out.println(tradeAnalyzer.OutputWorstTrade("Apple")); // Output: 100
    }
}

class Trade {
    int tradeId;
    String instrumentId;
    String buySell;
    int price;
    int volume;

    public Trade(int tradeId, String instrumentId, String buySell, int price, int volume) {
        this.tradeId = tradeId;
        this.instrumentId = instrumentId;
        this.buySell = buySell;
        this.price = price;
        this.volume = volume;
    }

    public int calculateProfitLoss(int currentPrice) {
        int pnl = (buySell.equals("BUY") ? (currentPrice - price) : (price - currentPrice)) * volume;
        return pnl;
    }
}

class WorstTrade {
    int tradeId;
    int pnlPerLot;

    public WorstTrade(int tradeId, int pnlPerLot) {
        this.tradeId = tradeId;
        this.pnlPerLot = pnlPerLot;
    }
}
