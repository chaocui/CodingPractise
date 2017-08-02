package leetcode.medium;

/**
 * Created by cc on 2016/8/6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
