package leetcode.medium;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
    	
    	int left = 0, right = nums.length - 1;
    	int[] result = new int[2];
    	result[0] = -1; result[1] = -1;
    	//left bound
    	//basically, if greater, search right.
    	//if less or equal, search left. eventually will find the left boundary if there is one.
    	//Same idea for searching right boundary.
    	while(left < right){
    		int mid = (left + right)/2;
    		if(target > nums[mid]) left = mid + 1;
    		else right = mid;
    	}
    	if(nums[left] != target) return result;
    	result[0] = left;
    	
    	//left first, then right, don't need to reset left.
    	right = nums.length - 1;
    	//right bound
    	while(left < right){
    		int mid = (left + right)/2;
    		if(target < nums[mid]) right = mid - 1;
    		else left = mid;
    	}
    	result[1] = left;
    	
    	return result;
    
    }
	
    
}
