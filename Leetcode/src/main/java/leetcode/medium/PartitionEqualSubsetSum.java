package leetcode.medium;

/**
 * Created by cc on 2017/1/26.
 */
public class PartitionEqualSubsetSum {

    //DP Model is important.
    //dp[i][j] means from 0-i, can we get sum j.
    //size of i is n(size of array), size of j is arraySum/2.

    //dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]
    //Important !!!! --->> either take nums[i] or not.
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        int length = nums.length;
        boolean[][] dp = new boolean[length][sum/2+1];
        /**
         * Only initialize dp[0][nums[0]] to true if it is not out of bound
         * */
        if(nums[0] <= sum/2)
            dp[0][nums[0]] = true;
        for(int i = 1; i < length; i++){
            for(int j = 1; j <= sum/2; j++){
                boolean notTake = false;
                //check j-nums[i], if it is negtive, means it is false.
                //otherwise, use it.
                if(j - nums[i] >= 0) notTake = dp[i-1][j-nums[i]];
                dp[i][j] = notTake || dp[i-1][j];
            }
        }
        return dp[length - 1][sum/2];
    }
}
