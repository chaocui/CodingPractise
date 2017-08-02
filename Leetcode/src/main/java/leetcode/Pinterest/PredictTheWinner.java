package leetcode.Pinterest;

/**
 * Created by cc on 2017/7/2.
 */
public class PredictTheWinner {

    /**
     * Can only pick from start or end.
     * */
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] board = new Integer[nums.length][nums.length];
        getResult(board, nums, 0, nums.length-1);
        return board[0][nums.length-1] >= 0;
    }


    //idea is: see how much i can get more than the other
    /**
     * if only one left, thats how much i can get more than other player.
     * if not, we use matrix to keep track from start to end, one can earn how many more than the other.
     * then we pick either start or end,
     * if pick start, start - (other player can earn more than me), is my net win
     * if pick end, end - (other player can earn more than me), is my net win.
     * */
    public int getResult(Integer[][] board, int[] nums, int start, int end){
        if(board[start][end] == null)
            board[start][end] = start == end ? nums[start] : Math.max(nums[start]-getResult(board, nums, start+1, end), nums[end]-getResult(board, nums, start, end-1));
        return board[start][end];
    }

}
