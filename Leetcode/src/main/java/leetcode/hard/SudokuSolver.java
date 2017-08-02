package leetcode.hard;

/**
 * Created by cc on 2017/6/10.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char m = '1'; m <= '9'; m++){
                        if(isValid(board, i, j, m)){
                            board[i][j] = m;
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    //if cannot fill 1-9 this cell, there is no solution then.
                    return false;
                }
            }
        }
        //if reach here, then we solve the problem, never reachable though.lol
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i ++){
            if(board[row][i] != '.' && board[row][i] == c) return false; //row
            if(board[i][col] != '.' && board[i][col] == c) return false; //col
            //cube
            int rowStart = 3*(row/3);
            int colStart = 3*(col/3);
            int rowIndex = rowStart + i/3;
            int colIndex = colStart + i%3;
            if(board[rowIndex][colIndex] != '.' && board[rowIndex][colIndex] == c) return false;
        }
        return true;
    }


}
