package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2017/3/21.
 */
public class IncreasingSubsequences {
    /**
     * Same as combination problems.
     * Just base condition is different
     * Basically, just use a temp to do backtracing.
     * add and remove from the temp result.
     * if meet base condition, add to result.
     *
     * !!!! Important, use set can deduplicate AUTOMATICALLY!!!!!!!!!!
     * */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> eachResult = new ArrayList<Integer>();
        getResult(result, eachResult, nums, 0);
        return new ArrayList<List<Integer>>(result);
    }

    private void getResult(Set<List<Integer>> result, List<Integer> eachResult, int nums[], int start){
        if(start > nums.length) return;
        if(eachResult.size() >= 2){
            result.add(new ArrayList<Integer>(eachResult));
        }
        for(int i = start; i < nums.length; i++){
            if(eachResult.size() == 0 || eachResult.get(eachResult.size() - 1) <= nums[i]){
                eachResult.add(nums[i]);
                getResult(result, eachResult, nums, i+1);
                eachResult.remove(eachResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {4,6,7,7};
        IncreasingSubsequences is = new IncreasingSubsequences();
        List<List<Integer>> result = is.findSubsequences(test);
        for(List<Integer> each: result){
            for(Integer i : each){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
