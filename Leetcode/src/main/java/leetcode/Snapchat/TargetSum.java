package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/17.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int[] result = new int[1];
        getResult(result, nums, 0,S,0);
        return result[0];
    }

    public void getResult(int[] result, int[] nums, int currentVal, int S, int start){
        if(start == nums.length){
            if(currentVal == S)
                result[0]++;
            return;
        }
        getResult(result, nums, currentVal+nums[start], S, start+1);
        getResult(result, nums, currentVal-nums[start], S, start+1);
    }
}
