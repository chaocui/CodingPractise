package leetcode.hard;

/**
 * Created by cc on 2016/11/5.
 */
public class BestTimeBuySellStockIV {

    //Good explaination
    //http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
    //diff = prices[i] - prices[i-1];
    //Normal thought:
    //profit[i][j] = Math.max(profit[i-1][j], profit[i-1][j-1]+diff);
    //Problem is if diff > 0, means i-1 to i this transaction can be merged to previous transaction. No need to waste this transaction since the price
    //is going up.
    //So that the function is not right, profit[i][j] is actually j-1 transaction, not j.

    //What to do:
    //Two matrix. 1. keep local profit, 2. keep global profit.
    //Local profit means that day i has to have a transaction.
    //If diff > 0, which means i - 1 to i can be merged to previous transaction, this will be day i-1, j transaction + diff (local[i-1][j] + diff).
    //So local[i][j] = local[i-1][j] + diff,
    //if diff <= 0, means that day i definitely lose money. So the maximum might be(has a chance) global[i-1][j-1], day i-1 global profit.
    //local[i][j] = global[i-1][j]
    //Take maximum of these two. local[i][j] = Math.max(local[i-1][j-1]+diff, global[i-1][j]);

    //Global matrix
    //global[i][j] = Math.max(local[i][j], global[i-1][j])

    public int maxProfit(int k, int[] prices) {

        if(prices.length < 2) return 0;
        if(k >= prices.length) return maxProfit2(prices);

        int local[][] = new int[prices.length][k+1];
        int global[][] = new int[prices.length][k+1];

        //First day can skip, profit always 0 for 1 day
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            //0 transaction always has 0 profit, skip too
            for(int j = 1; j <= k; j++){
                //Since its maximum j times transaction. if the jth transaction loose money, then we just do j-1 transaction.
                local[i][j] = Math.max(local[i-1][j] + diff, global[i-1][j-1]);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[prices.length-1][k];
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
