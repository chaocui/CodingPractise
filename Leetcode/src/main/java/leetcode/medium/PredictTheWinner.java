package leetcode.medium;

/**
 * Created by cc on 2017/3/29.
 */
public class PredictTheWinner {

    //recursively solve problem
    //however,
    //Think the return value in another way
    //if player 1 wins, it should return a value greater than or equal to 0.

    //can also use a cache to reduce recalculation.
    public boolean PredictTheWinner(int[] nums) {
        Integer[][]  map = new Integer[nums.length][nums.length];
        return getResult(nums, 0, nums.length-1, map) >= 0;
    }

    private int getResult(int[] nums, int start, int end, Integer[][] map){
        if(map[start][end] == null)
            map[start][end] = start == end ? nums[start] : Math.max(nums[start] - getResult(nums,start+1,end, map), nums[end] - getResult(nums, start, end-1, map));
        return map[start][end];
    }

}
