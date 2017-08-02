package leetcode.medium;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		//Basic idea is still binary search.
		//Just check which part is still in order.
		//two situations, 1. left in order, 2. right in order.
		//If target is in that part, go that part, otherwise, go to the other part.
		if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while(start < end){
        	int mid = (start + end)/2;
        	if(target == nums[mid])
        		return mid;
        	
        	//If left side is in order,equal is because there might be only one element
        	if(nums[start] <= nums[mid]){
        		//if in left range, go left
        		if(target >= nums[start] && target < nums[mid]){
        			end = mid - 1;
        		}
        		//else go right
        		else
        			start = mid + 1;
        	}
        	
        	//If right side is in order
        	else{
        		//go right
        		if(target > nums[mid] && target <= nums[end])
        			start = mid + 1;
        		//go left
        		else 
        			end = mid - 1;
        	}
        }
        if(nums[start] == target) return start;
        return -1;
    }
	
}
