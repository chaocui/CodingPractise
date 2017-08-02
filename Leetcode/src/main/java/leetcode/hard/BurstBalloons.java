package leetcode.hard;

import java.util.Arrays;

/**
 * Created by cc on 2016/11/13.
 */
public class BurstBalloons {

    /**
     * DP 三维DP
     * dp[i][j] means break balloons from i to j, the maximum points we can get
     *
     * Outer loop is the length of interval, which is from 1 to length.
     * mid loop is left bound, from 1 to length - k + 1
     * calculate the right bound based on outer loop and i.
     * inner loop is right bound, from i to i+k-1;
     *
     * so if i, j all break, means current result is nums[x]*nums[i-1]*nums[rightbound+1], becuase from i to j are broken,
     * so that last x broken get the value is nums[i-1]*nums[rightBound+1]*nums[x]
     *
     *     public int maxCoins(int[] iNums) {
     int n = iNums.length;
     int[] nums = new int[n + 2];
     for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
     nums[0] = nums[n + 1] = 1;
     int[][] dp = new int[n + 2][n + 2];
     for (int k = 1; k <= n; k++) {
     for (int i = 1; i <= n - k + 1; i++) {
     int j = i + k - 1;
     for (int x = i; x <= j; x++) {
     dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
     }
     }
     }
     return dp[1][n];
     }
     *
     * */
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int dp[][] = new int[length+2][length+2];
        int numsCopy[] = new int[length+2];
        numsCopy[0] = 1;
        numsCopy[length+1] = 1;
        for(int i = 1; i <= length; i++){
            numsCopy[i] = nums[i-1];
        }
        for(int k = 1; k <= length; k++){
            for(int i = 1; i <= length - k + 1; i++){
                int rightBound = i+k-1;
                for(int j = i; j <= rightBound; j++){
                    dp[i][rightBound] = Math.max(dp[i][rightBound], dp[i][j-1] + dp[j+1][rightBound] + numsCopy[i-1] * numsCopy[j] * numsCopy[rightBound+1]);
                }
            }
        }
        return dp[1][length];
    }
}
