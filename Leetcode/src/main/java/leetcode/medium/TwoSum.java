package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by cc on 2016/7/20.
 */
public class TwoSum {
    //If return index, cannot sort.
    //this version works when return combination
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            //remove dups
            if(left - 1 >=0 && nums[left] == nums[left-1]){
                left ++;
                continue;
            }
            if(right + 1 <= nums.length - 1 && nums[right] == nums[right+1]){
                right --;
                continue;
            }

            int sum = nums[left] + nums[right];
            if(sum == target){
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
            else if(sum < target){
                left ++;
            }
            else if(sum > target) {
                right--;
            }
        }
        return result;
    }

    public int[] twoSumIndex(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> dic = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            dic.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(dic.containsKey(diff) && dic.get(diff) != i){
                result[0] = dic.get(diff) >= i ? i : dic.get(diff);
                result[1] = dic.get(diff) <= i ? i : dic.get(diff);
                break;
            }
        }
        return result;
    }


    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] test = {0,4,3,0};
        int[] result = ts.twoSum(test, 0);
        System.out.println();
    }

}
