package leetcode.hard;

/**
 * Created by cc on 2016/11/12.
 */
public class FindTheDuplicateNumber {

    //Since duplicate can be more than 2, so sum does not work
    //Binary Search. Basic idea is binary search on count of numbers <= mid.
    //Count numbers less or equal to mid,
    //if >= mid, means dups happens in 0 to mid.
    //else, means dups happens in mid to right.
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        int mid = 0;
        while(left <= right){
            int count = 0;
            mid = (left + right)/2;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            //go left
            //If count equal to mid, means left just fit, so it should be in right.
            if(count > mid){
                right = mid-1;
            }
            //go right
            else{
                left = mid+1;
            }
        }
        return left;
    }
}
