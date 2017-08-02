package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class DiagonalTraverseMatrix {
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
        int r = matrix.length, c = matrix[0].length;
        int[] result = new int[r*c];
        int row = 0, col = 0;
        int[][] dir = {{-1,1},{1,-1}};
        int d = 0;
        //define two directions.
        //one goes up right, one goes bottom left.
        //check row and col each time see if they out of bound, if the do , change direction, and re-set the starting index.
        for(int i = 0; i < r*c; i++){
            result[i] = matrix[row][col];
            row = row + dir[d][0];
            col = col + dir[d][1];
            if(row >= r){row = r-1; col = col+2; d = 1 - d;}
            if(col >= c){col = c-1; row = row+2; d = 1 - d;}
            if(row < 0){row = 0; d = 1-d;}
            if(col < 0){col = 0; d = 1-d;}
        }
        return result;
    }

}
