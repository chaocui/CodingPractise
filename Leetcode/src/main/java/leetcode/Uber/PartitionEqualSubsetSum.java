package leetcode.Uber;

/**
 * Created by cc on 2017/7/16.
 */
public class PartitionEqualSubsetSum {

    //back tracing slow!
    //dp faster
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 == 1) return false;
        boolean[] used = new boolean[nums.length];
        return getResult(nums, sum/2, used);
    }

    public boolean getResult(int[] nums, int target, boolean[] used){
        if(target == 0) return true;
        if(target < 0) return false;
        for(int i = 0; i < nums.length; i ++){
            if(!used[i]){
                used[i] = true;
                if(getResult(nums, target - nums[i], used))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }

    /**
     * DP key part is model the DP storage.
     * dp[length][sum/2]
     * which means, from 0 to index i, we can form a sum.
     *
     *
     * dp[1][5] means that from index 0 to 1, we can sum to 5 or not.
     *
     * dp[length - 1][sum/2] means from 0 to length - 1, we can sum to sum/2.
     * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 == 1) return false;
        boolean[][] dp = new boolean[nums.length][sum/2+1];
        if(nums[0] <= sum/2) dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++){
            //since the question says all positive integers, so dp[*][0] = false;
            for(int j = 1; j <= sum/2; j++){
                boolean canSum = false;
                //if j >= current number, then from 0 to i-1 can sum to j-nums[i]
                if(j - nums[i] >= 0) canSum = dp[i-1][j-nums[i]];
                //either we take current number, we can sum.
                //or we dont take current number, from 0 to i-1 we can sum.
                dp[i][j] = canSum || dp[i-1][j];
            }
        }
        return dp[nums.length-1][sum/2];
    }
}
