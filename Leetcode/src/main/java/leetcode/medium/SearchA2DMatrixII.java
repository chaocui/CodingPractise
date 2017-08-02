package leetcode.medium;

/**
 * Created by cc on 2017/3/14.
 */
public class SearchA2DMatrixII {
    /**
     * Search from bottom left
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1, j = 0;
        while(i >= 0 && j < col){
            if(target > matrix[i][j]) j ++;
            else if(target < matrix[i][j]) i--;
            else return true;
        }
        return false;
    }

}
