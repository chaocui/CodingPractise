package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2016/7/20.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int diff = 0 - nums[i];
            List<List<Integer>> temp = twoSum(nums, i+1, diff);
            for(int j = 0; j < temp.size(); j++){
                List<Integer> each = temp.get(j);
                each.add(0, nums[i]);
                result.add(each);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int left = start;
        int right = nums.length - 1;
        while(left < right){
            if(left - 1 >= start && nums[left] == nums[left-1]){
                left ++;
                continue;
            }
            if(right + 1 <= nums.length - 1 && nums[right] == nums[right+1]){
                right --;
                continue;
            }

            int sum = nums[left] + nums[right];
            if(sum == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                result.add(temp);
                left ++;
                right --;
            }
            else if(sum < target){
                left ++;
            }
            else if(sum > target){
                right --;
            }
        }
        return result;
    }

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        int[] test = {-1,0,-1,1,2,4};
        ts.threeSum(test);
        System.out.println();
    }

}
