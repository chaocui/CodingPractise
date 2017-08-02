package leetcode.Airbnb;

import java.util.Arrays;

/**
 * Created by cc on 2017/6/30.
 */
public class NumberCoins {

    //since the maximum will be all 1s to construct amount, we set default to be amount+1.
    //any valid combination will be small than amount+1;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        NumberCoins nc = new NumberCoins();
        int[] test = {1,2,5};
        System.out.println(nc.coinChange(test, 11));
    }

}
