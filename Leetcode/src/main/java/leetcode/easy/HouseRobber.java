package leetcode.easy;

/**
 * Created by cc on 2016/4/11.
 */
public class HouseRobber {

    /**
     * DP, faster.
     * The DP formula: dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
     * Maximum sum is the maximum in num[i] + dp[i - 2] and dp[i - 1]
     * This is because you cannot take adjacent numbers and add them together.
     * either num[i] + max of i - 2 or max of i - 1
     */
    public int rob(int[] nums){

        int length = nums.length;
        if(length  == 0)
            return 0;
        if(length == 1)
            return nums[0];
        if(length == 2)
            return max(nums[0], nums[1]);

        int[] amount = new int[nums.length];

        amount[0] = nums[0];
        amount[1] = max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            amount[i] = max(nums[i] + amount[i - 2], amount[i - 1]);
        }

        return amount[nums.length - 1];

    }

    private int max(int a, int b){
        return a > b ? a : b;
    }

    /**
     * Recursive way of doing this.
     * Easy to think, but slow
     */
    private int rob1(int[] nums, int start){
        int length = nums.length;
        if(length - start <= 0)
            return 0;
        if(length - start == 1)
            return nums[0];
        if(length - start == 2)
            return max(nums[0], nums[1]);

        //if take first house
        int amount1 = nums[start] + rob1(nums, start + 2);

        //if take second house
        int amount2 = nums[start + 1] + rob1(nums, start + 3);

        return max(amount1, amount2);
    }




}
