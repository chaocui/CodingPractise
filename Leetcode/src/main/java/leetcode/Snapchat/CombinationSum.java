package leetcode.Snapchat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/6/18.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(0,0,target, candidates,result,tempResult);
        return result;
    }
    public void getResult(int start, int currentValue, int target, int[] candidates, List<List<Integer>> result, List<Integer> tempResult){
        if(currentValue == target) {
            result.add(new ArrayList<Integer>(tempResult));
            return;
        }
        if(currentValue > target)
            return;

        /**
         * Based on different requirements,
         *
         * For this issue, different sequence count as same result, so we keep track of start, we only go forward, not going back.
         * In this way, we can avoid duplicates.
         *
         * If different sequence count as different result.
         * Dont need to keep track of start, every time we just pick start from 0.
         *
         * So we find all different combinations.
         *
         * */
        for(int i = start; i < candidates.length; i++){
            tempResult.add(candidates[i]);
            getResult(i, currentValue + candidates[i], target, candidates, result, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
