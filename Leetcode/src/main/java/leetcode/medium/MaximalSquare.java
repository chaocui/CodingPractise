package leetcode.medium;

/**
 * Created by cc on 2017/5/24.
 */
public class MaximalSquare {

    /**
     * Clear explain
     * /http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
     *
     *
     * Similar question maximal rectangle. 1. use stack same as maximum histogram.
     * 2. DP. keep track of height, left, right.
     *    left[j], right[j] and height[j] means that
     *    row i col j form matrix, the maximum heights. to j.
     *    maximum left boundary, minimum right boundary. all from previous state.
     */
    public int maximalSquare1(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        /**
         * !!!!!!!!!!!!!!!!!!Important!!!!!!!!!!!!!!!!!!
         * dp[i][j] means
         * !!!!!!!!including vertex(point) matrix[i][j],!!!!!!!!!!!!!
         * !!!!!!!!including vertex(point) matrix[i][j],!!!!!!!!!!!!!
         * !!!!!!!!including vertex(point) matrix[i][j],!!!!!!!!!!!!!
         * 重要事情说三遍！
         * the maximum length of square edge.
         *
         * 1. either of i,j-1, i-1,j, i-1,j-1 is 0, then means including matrix[i][j], 1 is the maximum edge.
         * 2. if non of them is 0, means all the corresponding points are 1, so , just take the minimum and +1.
         * */
        int[][] dp = new int[r][c];
        int edge = 0;
        //copy first column.
        for(int i = 0; i < r; i++) {
            dp[i][0] = matrix[i][0] - '0';
            edge = Math.max(dp[i][0], edge);
        }
        //copy first row
        for(int j = 0; j < c; j++) {
            dp[0][j] = matrix[0][j] - '0';
            edge = Math.max(dp[0][j], edge);
        }
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                    edge = Math.max(edge, dp[i][j]);
                }
            }
        }
        return edge*edge;
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r+1][c+1];
        int edge = 0;
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                    edge = Math.max(edge, dp[i][j]);
                }
            }
        }
        return edge*edge;
    }

}
