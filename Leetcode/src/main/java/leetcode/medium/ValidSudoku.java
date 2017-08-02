package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/3/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //this is both row and column.
        for(int i = 0; i < 9; i++){
            //create three hash set, for each row, column, and cube
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                //meaning that there are dups in the row, i fixed, for each row
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                //meaning that there are dups in the col, i fixed, for each col
                if(board[j][i] != '.' && !col.add(board[j][i]))
                    return false;

                /**
                 * This looping blocks part of matrix is important and interesting.
                 * outer loop define starting of row and index.
                 * inner loop define shift of row and index.
                 * */
                //Find cube index.
                //i = 0, 1, 2 all first three lines cube.
                int rowStart = 3*(i/3);
                //i = 0, 1, 2, colStart are 0, 3, 6, the three cubes column start in first three lines.
                //same theory for 3, 4, 5, 6, 7, 8.
                int colStart = 3*(i%3);
                //j is from 0 to 8. so j/3 is 0 for j = 0 , 1, 2.
                //j%3 is 0,1,2 for j = 0,1,2
                //so for j from 0 to 2, we got 00,01,02;
                //same theory, j from 3 to 5, we got 10,11,12
                //same theory, j from 6 to 8, we got 20,21,22. which is first cube. for i = 0;

                //When i = 1, colStart = 3. so we got 03,04,05;13,14,15;23,24,25; which is second cube.
                int rowIndex = rowStart + j/3;
                int colIndex = colStart + j%3;
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex]))
                    return false;
            }
        }
        return true;
    }
}
