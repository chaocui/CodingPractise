package leetcode.Uber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/6/14.
 */
public class SudokuValidator {
    public boolean validate(int[][] board){
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> cube = new HashSet<>();
        for(int i = 0; i < 9; i++){
            row = new HashSet<>();
            col = new HashSet<>();
            cube = new HashSet<>();
            for(int j = 0; j < 9; j++){
                //check row
                if(board[i][j] != 0 && !row.add(board[i][j])) return false;

                //check column
                if(board[j][i] != 0 && !col.add(board[j][i])) return false;

                //check cube
                int rowStart = 3*i/3;
                int colStart = 3*i%3;
                int rowIndex = rowStart + i/3;
                int colIndex = colStart + i%3;
                if(board[rowIndex][colIndex] != 0 && !cube.add(board[rowIndex][colIndex])) return false;
            }
        }
        return true;
    }

}
