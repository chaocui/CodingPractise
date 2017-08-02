package leetcode.medium;

/**
 * Created by cc on 2016/12/17.
 */
public class BattleshipsInBoard {

    //Basically, count how many starts with X
    //if current is . skip,
    //if current is X and its left or up is X too, means we already counted, skip also.
    public int countBattleships(char[][] board) {
        if(board.length == 0){
            return 0;
        }
        int result = 0, r = board.length, c = board[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == '.' || (i > 0 && board[i-1][j] == 'X') || (j > 0 && board[i][j-1] == 'X')){
                    continue;
                }
                result++;
            }
        }
        return result;
    }

}
