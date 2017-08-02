package leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest {

	//Basic idea, sort the array first
	//Then for each element, loop through left of the elements.
	//If the sum is greater than target, move right to left.
	//if sum is less than target, move left to right.
	//if equal, return.(Assuming only one result)
    public int threeSumClosest(int[] nums, int target) {
    	if(nums.length < 3) return 0;
    	Arrays.sort(nums);
    	int ans = nums[0] + nums[1] + nums[2];
    	for(int i = 0; i < nums.length - 2; i++){
    		int j = i + 1, k = nums.length-1;
    		while(j < k){
    			int sum = nums[i] + nums[j] + nums[k];
    			if(Math.abs(sum - target) < Math.abs(ans - target))
    				ans = sum;
    			if(sum == target) return sum;
    			if(sum > target) k--;
    			else j++;
    		}
    	}
    	return ans;
    }
	
}
