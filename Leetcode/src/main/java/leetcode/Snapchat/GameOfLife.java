package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/18.
 */
public class GameOfLife {

    /**
     * Solve in place,
     * define to new status
     * 0 is both die current and next
     * 1 is both live current and next
     * 2 is die next, live current
     * 3 is live next, die current
     * */
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        //8 directions
        int[][] d = {{-1, -1},{-1, 0},{-1, 1},{0, -1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int count = 0;
                for(int m = 0; m < 8; m++){
                    int x = i + d[m][0];
                    int y = j + d[m][1];
                    if( x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
                            (board[x][y] == 1 || board[x][y] == 2))
                        count++;
                }
                if((count < 2 || count > 3) && board[i][j] == 1) board[i][j] = 2;
                else if(board[i][j] == 0 && count == 3) board[i][j] = 3;
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++)
                board[i][j] = board[i][j]%2;
        }
    }
}
