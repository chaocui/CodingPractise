package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	//same idea as Combination Sum, just base condition has one more which is track the number of numbers has been used.
	public List<List<Integer>> combinationSum3(int k, int n) {
        int[] input = {1,2,3,4,5,6,7,8,9};
        List<Integer> currentResult = new ArrayList<Integer>();
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        getResult(k,n,input,currentResult,result,0);
        return result;
    }

	
	private void getResult(int k, int n, int[] input, List<Integer> currentResult, List<List<Integer>> result, int start){
		if(k == 0 && n == 0){
			result.add(new ArrayList<Integer>(currentResult));
			return;
		}
		if(k < 0 && n < 0) return;
		
		for(int i = start; i < input.length; i++){
			currentResult.add(input[i]);
			getResult(k-1,n-input[i], input, currentResult, result, i+1);
			currentResult.remove(currentResult.size() - 1);
		}
	}
	
}
