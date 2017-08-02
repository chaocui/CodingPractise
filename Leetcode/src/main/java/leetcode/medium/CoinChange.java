package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2016/11/20.
 */
public class CoinChange {

    //DP,
    //dp[i] means i amount of money, least coins needed.
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int dp[] = new int[amount+1];
        //fill array with amount + 1.
        //for amount money, need most amount coins(all 1s)
        //So fill with amount + 1, if this is not changed, means no way to give the change.
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    //take the small one between current dp[i] and the one take out this coin + 1.
                    //if the one take out this coin do not have a legit value, dp[i] will remain amount + 1;
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){
        CoinChange cc = new CoinChange();
        int coins[] = {1};
        System.out.println(cc.coinChange(coins, 1));
    }
}
