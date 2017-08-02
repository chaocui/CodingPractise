package leetcode.medium;

/**
 * Created by cc on 2017/3/15.
 */
public class GuessNumberHigherOrLowerII {
    /**
     * Basic idea,
     * if there are only two numbers in the range.
     * we always guess from the smaller one, we can guarantee that we spend smaller amount and guess right.
     * because if they pick the first one, we dont spend any, if they pick larger one, we spend smaller.
     * So dp[i][j] if i = j - 1, dp[i][j] = i; which is the smaller one.
     *
     * then we use dp.
     *　
     * DP function is we pick k from i to j. then max = k + max(dp[i][k-1], dp[k+1][j]).
     * then we compare this with the global minimum, take the smaller one. set dp[i][j] = global minimum.
     * reset the global minimum before we start loop through i to j. before the k loop.
     * we need to find out each  i to j, the minimum cost of maximum cost.
     *
     * then we return dp[1][n]
     * */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        /**
         * note the looping index here.
         * j is outer most,
         * i is middle layer,
         * k is inner most.
         *
         * basically, j is the right side boundary, from 2 to the end
         * i is left side boundary, from j - 1 to 1.
         * k is between i and j so k start from i+1 to j - 1
         * */
        for(int j = 2; j <=n; j++){
            for(int i = j - 1; i > 0; i--){
                int min = Integer.MAX_VALUE;
                for(int k = i+1; k < j; k++){
                    int max = k + Math.max(dp[i][k-1],dp[k+1][j]);
                    min = Math.min(max, min);
                }
                //if i == j - 1, then we take dp[i][j] = i. expalined above.
                dp[i][j] = i+1 == j ? i : min;
            }
        }
        return dp[1][n];
    }

}
