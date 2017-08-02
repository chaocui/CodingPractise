package leetcode.easy;

/**
 * Created by cc on 2016/4/10.
 */
public class BuyStock {

    public int maxProfit(int[] prices){
        if(prices.length <= 1)
            return 0;

        int profit = prices[1] - prices[0];
        int minPrice = min(prices[0], prices[1]);

        for(int i = 2; i < prices.length; i++){
            minPrice = min(minPrice, prices[i]);
            profit = max(profit, prices[i] - minPrice);
        }

        return profit > 0 ? profit : 0;
    }

    private int min(int a, int b){
        return a < b ? a : b;
    }

    private int max(int a, int b){
        return a > b ? a: b;
    }

    public int maxProfit1(int[] prices){
        if(prices.length <= 1)
            return 0;

        int max = 0;
        int sum = max;
        for(int i = 0; i < prices.length - 1; i++){
            int profit = prices[i+1] - prices[i];
            sum += profit;
            if(sum < 0)
                sum = 0;
            else
                max = max(max, sum);
        }
        return max;
    }
}
