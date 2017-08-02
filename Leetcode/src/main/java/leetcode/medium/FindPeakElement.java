package leetcode.medium;

/**
 * Created by cc on 2017/1/25.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int preIndex = i - 1;
            int postIndex = i + 1;
            boolean pre = false;
            boolean post = false;
            if(preIndex < 0 || nums[i] > nums[preIndex])
                pre = true;
            if(postIndex > nums.length-1 || nums[i] > nums[postIndex])
                post = true;

            if(pre && post)
                return i;
        }
        return -1;
    }

    //Binary Search is faster.
//    If num[i-1] < num[i] > num[i+1], then num[i] is peak
//    If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
//    If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
//    If num[i-1] > num[i] < num[i+1], then both sides have peak
//            (n is num.length)
    public int findPeakElement1(int[] nums){
        return helper(0, nums.length-1, nums);
    }

    private int helper(int start, int end, int[] nums){
        if(start == end){
            return start;
        }
        else if(start+1==end){
            if(nums[start] > nums[end]){
                return start;
            }
            return end;
        }
        else{
            int mid = (start + end)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            //go right
            else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                return helper(mid+1,end,nums);
            }
            //go left
            else{
                return helper(start,mid-1,nums);
            }
        }
    }
}
