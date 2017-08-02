package leetcode.Pinterest;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignTicTacToe {

    /** Initialize your data structure here. */
    char[][] board;
    char[] players;
    int n;
    public DesignTicTacToe(int n) {
        board = new char[n][n];
        players = new char[]{' ', 'X' , 'O'};
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = players[player];
        if(win(row, col, player))
            return player;
        return 0;
    }

    private boolean win(int row, int col, int player){
        int i = 0;
        //check row
        for(i = 0; i < n; i++){
            if(players[player] != board[row][i])
                break;
        }
        //check col
        if(i == n) return true;
        for(i = 0; i < n; i++){
            if(players[player] != board[i][col])
                break;
        }
        if(i == n) return true;
        //if placed in center(if there is center) then left, right all need to check
        if(row + col == n - 1  && row == col){
            for(i = 0; i < n; i++){
                if(board[i][i] != players[player])
                    break;
            }
            if(i == n) return true;
            for(i = 0; i < n; i++){
                if(board[i][n-i-1] != players[player])
                    break;
            }
            if(i == n) return true;
        }
        //only check diagnose
        if(row == col){
            for(i = 0; i < n; i++){
                if(board[i][i] != players[player])
                    break;
            }
            if(i == n) return true;
        }
        //check the other diagnose
        if(row + col == n - 1){
            for(i = 0; i < n; i++){
                if(board[i][n-i-1] != players[player])
                    break;
            }
            if(i == n) return true;
        }
        return false;
    }

}
