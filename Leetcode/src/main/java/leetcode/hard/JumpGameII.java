package leetcode.hard;

/**
 * Created by cc on 2016/11/7.
 */
public class JumpGameII {

    //Basic idea
    //Maintain a window, start, end index.
    //for each window, find the maximum place we can go. update start to end + 1, end to maxPosition. Add 1 to steps.
    //outer loop make sure end < length - 1. since end >= length - 1, means we reach the end.
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int start = 0;
        int end = 0;
        int result = 0;
        while(end < nums.length-1){
            int max = Integer.MIN_VALUE;
            while(start <= end){
                int steps = nums[start];
                max = Math.max(start + steps, max);
                start ++;
            }
            end = max;
            result ++;
        }
        return result;
    }

}
