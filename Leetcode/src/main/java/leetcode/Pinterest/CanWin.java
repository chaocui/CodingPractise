package leetcode.Pinterest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/6/20.
 */
public class CanWin {

    //Can I win, pick any from 1 to maximum.
    //Predict winner, can only pick from two ends.
    //Use hash map key is current used array status, if exist, just use it to speed up.
    public boolean canWin(int[] board, int desireTotal){
        //return false;
        if(desireTotal <= 0) return true;
        int sum = 0;
        for(int i : board)
            sum += i;
        if(sum < desireTotal) return false;
        boolean[] used = new boolean[board.length];
        return getResult(board, used, desireTotal);
    }

    public boolean getResult(int[] board, boolean[] used, int desireTotal){
        //my turn to pick, if desireTotal is <= 0, i cannot win, the other user already win
        if(desireTotal <= 0) return false;
        for(int i = 0;i < board.length; i++) {
            if (!used[i]) {
                used[i] = true;
                //if the other user pick and cannot win.
                if (!getResult(board, used, desireTotal - board[i])) {
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
