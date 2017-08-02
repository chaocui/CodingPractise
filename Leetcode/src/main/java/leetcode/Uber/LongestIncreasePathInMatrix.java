package leetcode.Uber;

/**
 * Created by cc on 2017/6/21.
 */
public class LongestIncreasePathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int result = dfs(i,j,matrix,cache);
                max = Math.max(result, max);
            }
        }
        return max;
    }

    public int dfs(int x, int y, int[][] matrix,int[][] cache){
        if(cache[x][y] != 0) return cache[x][y];
        /**
         * Initial value of max should be 1,
         * because if current position cannot go anywhere,
         * cache[x][y] = max, which is 1. since any value has at least 1 length.
         * */
        int r = matrix.length, c = matrix[0].length, max = 1;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < 4; i++){
            int px = x + dir[i][0];
            int py = y + dir[i][1];
            //if cannot go any direction, then max will be 1 by default.
            if(px >= r || px < 0 || py >= c || py < 0 || matrix[x][y] >= matrix[px][py]) continue;
            int result = 1 + dfs(px, py, matrix, cache);
            max = Math.max(result, max);
        }
        cache[x][y] = max;
        return cache[x][y];
    }

}
