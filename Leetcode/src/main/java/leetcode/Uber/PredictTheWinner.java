package leetcode.Uber;

/**
 * Created by cc on 2017/6/11.
 */
public class PredictTheWinner {

    //matrix[i][j] indicates a VALUE m that from i to j, whoever first pick can have m more than the other guy.
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] matrix = new Integer[nums.length][nums.length];
        return getResult(matrix, 0, nums.length-1,nums) >= 0;
    }

    public int getResult(Integer[][] matrix, int start, int end, int[] nums){
        //if only one, then first picker must have nums[start] more than second picker.
        //meaning that, from i to i, the maximum difference can make by any one is nums[i]
        //So for any one picks start, then difference can make is nums[start] - getResult() -- the other person can make maximum
        //same thing if pick end, then take the bigger one as the current maximum difference from start to end.
        if(matrix[start][end] == null){
            matrix[start][end] = start == end ? nums[start] : Math.max(nums[start]-getResult(matrix, start+1, end, nums),
                    nums[end] - getResult(matrix, start, end - 1, nums));
        }
        return matrix[start][end];
    }

}
