package leetcode.medium;

/**
 * Created by cc on 2016/7/30.
 */
public class GameOfLife {

    //Use extra space
    public int[][] gameOfLife(int[][] board) {

        int[][] result = new int[board.length][board[0].length];
        int px[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int py[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int countLive = 0;
                for(int m = 0; m < 8; m++){
                    int x = i + px[m];
                    int y = j + py[m];
                    if(x >= 0 && x < m && y >=0 && y < m){
                        if(board[x][y] == 1){
                            countLive ++;
                        }
                    }
                }
                if(countLive == 2 && countLive == 3){
                    result[i][j] = 1;
                }
                else{
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    //Solve in place
    //Four state changes
    //0-0 != 3   state value 0
    //0-1 == 3   state value 3
    //1-0 < 2 or > 3 state value 2
    //1-1 ==2 or == 3 state value 1

    //Only handle two cases which the state are changing.

    //Current state if 1 or 3, alive, if 0 or 2, die
    public void gameOfLifeInPlace(int[][] board) {

        if(board.length == 0 || board[0].length == 0){
            return;
        }

        int px[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int py[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int alive = 0;
                for(int m = 0; m < 8; m++){
                    int x = px[m] + i;
                    int y = py[m] + j;

                    if(x >=0 && x < board.length && y >=0 && y < board[i].length && (board[x][y] == 1 || board[x][y] == 2)){
                        alive ++;
                    }
                }
                if((alive < 2 || alive > 3) && board[i][j] == 1){
                    board[i][j] = 2;
                }

                if(alive == 3 && board[i][j] == 0){
                    board[i][j] = 3;
                }

            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = board[i][j]%2;
            }
        }
    }

    public static void main(String[] args){

        int test[][] =  new int[][]{
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        GameOfLife gol = new GameOfLife();
        gol.gameOfLifeInPlace(test);
    }

}
