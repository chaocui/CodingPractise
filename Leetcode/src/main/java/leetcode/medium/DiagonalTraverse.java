package leetcode.medium;

/**
 * Created by cc on 2017/3/30.
 */
public class DiagonalTraverse {

    /**
     * Basic idea,
     * two walk directions.
     * 1. up right, row - 1, column +1
     * 2. left down, row + 1, column -1;
     *
     * Four conditions.
     * Has to be checked in sequence.
     * 1. row >= m, if row >=m, means goes left down, reset row = m, and column was substract 1, but we need to go up right, need to starting by column+2
     * 2. col >= n  same reason above
     * 3. row < 0 if row < 0, means goes up right, so column already added one which is the next staring column, so we need to reset row to 0 and change direction
     * 4. col < 0 if column < 0, means goes down left, so row already added one, same reason above.
     * */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m*n];
        //up and down
        int[][] direction = {{-1,1},{1,-1}};
        //initially goes up.
        int d = 0,row = 0, col = 0;
        for(int i = 0; i < m*n; i++){
            result[i] = matrix[row][col];
            row = row + direction[d][0];
            col = col + direction[d][1];
            if(row >= m){row = m - 1; col = col+2; d = 1-d;}
            if(col >= n){col = n - 1; row = row+2; d = 1-d;}
            if(row < 0){row = 0; d = 1-d;}
            if(col < 0){col = 0; d = 1-d;}
        }
        return result;
    }

    //Brilliant solution!!!!

}
