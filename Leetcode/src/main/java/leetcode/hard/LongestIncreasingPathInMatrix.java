package leetcode.hard;

/**
 * Created by cc on 2016/11/22.
 */
public class LongestIncreasingPathInMatrix {
    /**
     * dp[i][j] means starting from matrix[i][j], maximum length of path.
     * calculate starting from each position, the maximum,
     * for each calculation, use dfs,
     * */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows][cols];
        int result = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result = Math.max(dfs(i,j,matrix,dp),result);
            }
        }
        return result;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] dp){

        //这种上下左右 或者周围八个坐标的 可以predefine数组 然后循环。
        if(dp[i][j] != 1) return dp[i][j];
        int xP[] = {-1,1,0,0};
        int yP[] = {0,0,-1,1};
        int max = 1;
        for(int m = 0; m < 4; m++){
            int x = i + xP[m];
            int y = j + yP[m];
            //If its out of bound or its not increasing, continue to next position.
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[i][j] >= matrix[x][y]) continue;
            int temp = dfs(x,y,matrix,dp)+1;
            max = Math.max(max,temp);
        }
        //Dont forget to assign maximum length to current start position.
        dp[i][j] = max;
        return max;
    }

}
