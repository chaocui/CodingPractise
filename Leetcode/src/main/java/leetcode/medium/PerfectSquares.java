package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/3/18.
 */
public class PerfectSquares {

    //DP function;
    //inner loop condition. i - j*j >=0
    //dp[i] = Math.min(dp[i - j*j]+ 1, dp[i- j*j] + 1....)
    public int numSquares(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n+1];
        //Initialize all elements in array to MAX_INTEGER, since we need to take min value.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int j = 1;
            while(i - j * j >= 0){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }

}
