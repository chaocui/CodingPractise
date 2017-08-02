package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/17.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char m = '1'; m <= '9'; m++){
                        if(valid(i,j,board,m)){
                            board[i][j] = m;
                            //if we can solve, return true,
                            //otherwise, back tracing.
                            //we dont want to return if cannot solve.
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        //if all board is filled and all valid.
        return true;
    }

    public boolean valid(int r, int c, char[][] board, char num){
        for(int i = 0; i < 9; i++){
            if(board[i][c] != '.' && board[i][c] == num) return false;
            if(board[r][i] != '.' && board[r][i] == num) return false;

            int rowStart = r/3*3;
            int colStart = c/3*3;
            int row = rowStart + i/3;
            int col = colStart + i%3;
            if(board[row][col] != '.' && board[row][col] == num) return false;
        }
        return true;
    }


}
