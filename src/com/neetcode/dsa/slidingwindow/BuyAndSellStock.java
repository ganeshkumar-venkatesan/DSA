package com.neetcode.dsa.slidingwindow;

import java.util.HashMap;

public class BuyAndSellStock {
    public static void main(String[] args) {
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        //System.out.println(buyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(buyAndSellStock.maxProfit(new int[]{7,6,5,3,2,1}));
        //System.out.println(buyAndSellStock.maxConsecutiveSum(new int[]{7,1,5,3,6,4},3));
    }

    public int maxProfit(int[] prices) {
        int left =0;
        int right = 1;
        int maxProfit =0;
        while(right< prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public int maxProfitV2(int prices[]){
        int least = Integer.MAX_VALUE;
        int op = 0;
        int pp = 0;

        for(int i = 0; i < prices.length; i++) {
            least = Math.min(least, prices[i]);
            pp = prices[i] - least;
            op = Math.max(pp, op);
        }
        return op;
    }


    public int maxConsecutiveSum(int[] data, int k){
        //{7,1,5,3,6,4}
        // find the first window sum
        if(data.length< k)return 0;
        int currentWindow = 0;
        for(int i =0; i<k; i++){
            currentWindow +=data[i];
        }
        int maxSum = currentWindow;
        for(int j = k; j< data.length-1; j++){
            currentWindow = currentWindow + data[j] - data[j-k];
            if(currentWindow>maxSum){
                maxSum = currentWindow;
            }
        }
        return maxSum;
    }

}
