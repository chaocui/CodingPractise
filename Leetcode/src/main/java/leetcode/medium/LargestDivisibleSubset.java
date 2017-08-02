package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/3/9.
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i]%nums[j] == 0){
                    //basically, if nums[i] can be divided by nums[j],
                    //meaning that nums[j] has 1 more element can be added, nums[i] will take the larger one between nums[i] and nums[j]+1;
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxIndex = 0;
        for(int i = 0; i < dp.length; i++){
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }

        //Starting from maxIndex to 0.
        int dividend = nums[maxIndex];
        int count = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--){
            //if only check dividend%nums[i], we cannot make sure the current number is part of the subset.
            //for example [4,8,10,240]
            //starting from 240.
            //when we check 10, it satisfy, but dp[2] = 0. not 3. so we need count == dp[i] to double check if the element is part of the subset.

            //basically we only consider the numbers which less than current.
            //Since it current belongs to larger subset, it will be contained in the subset of the value which is greater than itself.
            if(dividend % nums[i] == 0 && count == dp[i]){
                result.add(nums[i]);
                //update dividend to current one,
                //then check if it can be divided by next nums[i]
                dividend = nums[i];
                //update count.
                //since we need to compare count with the dp count, to make sure this current number is part of the result.
                count--;
            }
        }
        return result;

    }

    public static void main(String[] args){
        int[] test = {4,8,10,240};
        LargestDivisibleSubset lds = new LargestDivisibleSubset();
        lds.largestDivisibleSubset(test);
    }

}
