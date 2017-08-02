package leetcode.medium;

public class CombinationSumIv {
	
	//same idea as Combination Sum, the only difference is that 
	//we only need to count.
	//So we have a size 1 array to keep track of result
	//Base condition is when target is 0, add 1 to result.
    public int combinationSum4II(int[] nums, int target) {
        int[] result = new int[1];
        getResult(nums, target, result);
        return result[0];
    }
    
    private void getResult(int[] nums, int target, int[] result){
    	if(target == 0){
    		result[0]++;
    		return; 
    	}
    	for(int i = 0 ; i < nums.length; i++){
    		if(target >= nums[i]){
    			getResult(nums, target-nums[i], result);
    		}
    	}
    }
    
    public int combinationSum4(int[] nums, int target){
    	int[] result = new int[target+1];
    	//0 always has 1 result.
    	result[0] = 1;
    	for(int i = 1; i < result.length; i++){
    		for(int j = 0; j < nums.length; j++){
    			if(i >= nums[j])
    				result[i] = result[i] + result[i-nums[j]];
    		}
    	}
    	
    	return result[target];
    } 
    
}
