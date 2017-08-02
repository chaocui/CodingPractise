package leetcode.medium;

import java.util.Random;

/**
 * Created by cc on 2017/2/1.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        Random r = new Random();
        r.nextInt();
        return valid(nums,S,0,0);
    }

    private int valid(int[] nums, int S, int index, int currentResult){
        if(index == nums.length){
            if(S == currentResult)
                return 1;
            else
                return 0;
        }

        int add = currentResult + nums[index];
        int substract = currentResult - nums[index];
        return valid(nums, S, index+1, add) + valid(nums, S, index+1, substract);
    }

}
