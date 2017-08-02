package leetcode.medium;

/**
 * Created by cc on 2017/2/4.
 */
public class HouseRobberII {

    //Write util function to find from low to hi, maximum, same as house rob I
    //Basically, pick 0, break circle to a line.
    //Then rob 0 or not. pick the maximum.
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private int rob(int[] nums, int start, int end){
        //include and exclude are previous include and exclude.
        int include = 0, exclude = 0;
        for(int j = start; j <= end; j++){
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }
}
