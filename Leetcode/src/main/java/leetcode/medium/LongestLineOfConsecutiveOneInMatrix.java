package leetcode.medium;

/**
 * Created by cc on 2017/5/27.
 */
public class LongestLineOfConsecutiveOneInMatrix {

    /**
     * DP
     * dp[i][j][4] mark -- to point i,j, four directions longest consecutive one.
     * only update if M[i][j] = 1;
     */
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int r = M.length, c = M[0].length;
        int[][][] dp = new int[r+1][c+1][4];
        int max = 0;
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(M[i-1][j-1] == 1){
                    //up
                    dp[i][j][0] = dp[i-1][j][0] + 1;
                    //left
                    dp[i][j][1] = dp[i][j-1][1] + 1;
                    //diagnose
                    dp[i][j][2] = dp[i-1][j-1][2] + 1;
                    //anti-diagnose
                    if(j + 1 <= c)
                        dp[i][j][3] = dp[i-1][j+1][3] + 1;
                    max = Math.max(max, Math.max(dp[i][j][0],dp[i][j][1]));
                    max = Math.max(max, Math.max(dp[i][j][2],dp[i][j][3]));
                }
            }
        }
        return max;
    }
}
