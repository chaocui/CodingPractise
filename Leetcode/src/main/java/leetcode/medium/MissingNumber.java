package leetcode.medium;

/**
 * Created by cc on 2016/7/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            result += nums[i];
        }
        return n*(n+1)/2 - result;
    }
}
