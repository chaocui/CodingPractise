package leetcode.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/5/31.
 */
public class ThreeSum {



    /**
     *
     * Same number can be used multiple times.
     *
     * If number can be re-use.
     *  Still need to skip the same number in the outer loop.
     * 1. find two sum function, starting at the same index as outer loop.
     * 2. find two sum, l <= r instead of l < r.
     * */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            //if previous number has been processed, skip current same number to avoid duplication.
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int diff = 0 - nums[i];
            List<List<Integer>> tResult = twoSum(nums, i, nums.length-1, diff);
            for(List<Integer> l : tResult){
                l.add(0,nums[i]);
                result.add(l);
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int sum){
        List<List<Integer>> result = new ArrayList<>();
        int l = start, r = end;
        while(l <= r){
            if(l > start && nums[l-1] == nums[l]){
                l++;
                continue;
            }
            if(r < end && nums[r+1] == nums[r]){
                r--;
                continue;
            }
            int tempSum = nums[l]+nums[r];
            if(sum == tempSum){
                List<Integer> t = new ArrayList<>();
                t.add(nums[l]);
                t.add(nums[r]);
                result.add(t);
                l++;
                r--;
            }
            else if(tempSum < sum)
                l++;
            else
                r--;
        }
        return result;
    }
}
