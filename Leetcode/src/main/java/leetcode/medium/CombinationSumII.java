package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

	
	public List<List<Integer>> combinationSum2II(int[] candidates, int target) {
        List<Integer> currentResult = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> deDup = new HashSet<String>();
        getResult(candidates, target, currentResult, result, 0, deDup);
        return result;
    }
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<Integer> currentResult = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(candidates, target, currentResult, result, 0);
        return result;
    }
	
	private void getResult(int[] candidates, int target, List<Integer> currentResult, List<List<Integer>> result, int start){
		if(target < 0) return;
		if(target == 0){
			result.add(new ArrayList<Integer>(currentResult));
			return;
		}
		
		for(int i = start; i < candidates.length; i++){
			//if i > start, means current loop move forward.
			//So means previous i is done its job. Which is not part of the result anymore.
			//So now we check if current i and i - 1 the same. if they are, we just skip.
			//For example
			//[1, 1, 2, 5, 6, 7, 10]
			//i starting at 0, the most top level recursion stack.
			//when i = 1, means that currentResult.remove() has been invoked.
			//means that the candidates[0] is removed from currentResult.
			//So if now candidate is the same as the previous candidate. we just skip, since we already processed this number.
			
			if(i > start && candidates[i] == candidates[i-1]) continue;
			currentResult.add(candidates[i]);
			getResult(candidates,target-candidates[i],currentResult,result, i+1);
			currentResult.remove(currentResult.size()-1);
		}
	}
	
	
	//Same idea as Combination Sum, only difference is element cannot be used twice.
	//So each time add one to currentResult, move start 1 step forward.
	private void getResult(int[] candidates, int target, List<Integer> currentResult, List<List<Integer>> result, int start, Set<String> deDup){
		if(target < 0) return;
		if(target == 0){
			
			List<Integer> temp = new ArrayList<Integer>(currentResult);
			Collections.sort(temp);
			StringBuilder sb = new StringBuilder();
			for(int i : temp)
				sb.append(i+"-");
			
			if(deDup.add(sb.toString()))
				result.add(new ArrayList<Integer>(currentResult));
			return;
		}
		
		for(int i = start; i < candidates.length; i++){
			currentResult.add(candidates[i]);
			getResult(candidates,target-candidates[i],currentResult,result, i+1, deDup);
			currentResult.remove(currentResult.size()-1);
		}
	}

}
