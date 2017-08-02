package leetcode.hard;

/**
 * Created by cc on 2016/11/29.
 */
public class BestTimeBuySellStockIII {

    public int maxProfit(int[] prices) {

        if(prices.length < 2){
            return 0;
        }

        if(prices.length == 2){
            int diff = prices[1] - prices[0];
            return diff <= 0 ? 0 : diff;
        }

        int k = 2;
        int localProfit[][] = new int[prices.length][3];
        int globalProfit[][] = new int[prices.length][3];

        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= k; j++){
                localProfit[i][j] = Math.max(localProfit[i-1][j]+diff, globalProfit[i-1][j-1]);
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i-1][j]);
            }
        }

        return globalProfit[prices.length-1][2];
    }

    //For each price, we calculate 4 values.
    public int maxProfit1(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int i = 0; i < prices.length; i++){
            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }

        return sell2;
    }

}
