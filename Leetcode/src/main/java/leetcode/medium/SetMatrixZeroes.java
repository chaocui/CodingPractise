package leetcode.medium;

/**
 * Created by cc on 2017/3/14.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        //used to mark first column. if any row, first column is 0, mark this as 0 means that we need to fill first column
        int col0 = 1;
        //Other than this, first column of each row is used to mark for each row needs to be filled with 0s.
        //from column1 to end, first row of each column mark for each column need to be filled with 0s.
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0) col0 = 0;
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    //mark row i and column j need to be filled at the border.
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = row - 1; i >= 0; i--){
            //since first column is controlled by col0. we deal with it separate.
            for(int j = col - 1; j >= 1; j--){
                if(matrix[i][0]==0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}
