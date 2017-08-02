package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/18.
 */
public class CombinationSumIV {

    /**
     * If we only need count, then we just do DP.
     * Create one dimention array of size target + 1.
     * dp[0] = 1;
     * pick nothing, always has 1.
     *
     * //Add up to i - currentNumber, there are m ways, so add to i, there are current dp[i] + dp[i-currentNumber]
     * dp[i] = dp[i] + dp[i-currentNumber]

     * only add if i >= currentNumber.
     * This check happens in inner loop, inner loop will loop through all numbers in given array.
     * outer loop will loop through the DP array.
     * */


}
