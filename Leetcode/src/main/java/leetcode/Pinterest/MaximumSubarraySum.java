package leetcode.Pinterest;

/**
 * Created by cc on 2017/6/20.
 */
public class MaximumSubarraySum {
    public int maxSum(int[] nums){
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num : nums){
            sum += num;
            if(sum < 0) sum = 0;
            max = Math.max(sum, max);
        }
        return max;
    }
}
