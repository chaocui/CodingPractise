package leetcode.Facebook;

/**
 * Created by cc on 2017/6/3.
 */
public class UniquePathII {

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];
        for(int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j < c; j++){
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }

    //一维数组解法，更少 extra space.
    //array is the size of number of columns.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int c = obstacleGrid[0].length, r = obstacleGrid.length;
        int[] dp = new int[c];
        dp[0] = 1;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                //if current value is 1, set dp[j] = 0, not reachable.
                //
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                else if(j > 0){
                    //basically, before update, dp[j] is number of ways to column j row i - 1;
                    dp[j] = dp[j-1]+dp[j];
                }
            }
        }
        return dp[c-1];
    }
}
