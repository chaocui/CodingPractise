package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class RotateArray {

    /**
     * Method 1.
     * Brute force.
     * Just rotate k times, each time shift 1 step right.
     * Method 2.
     * Concatenate two numbers together.
     * From length - 4, take length elements. that will be result.
     * Method 3.
     * Most tricky, fast and least space.
     * reverse the string,
     * reverse first k elements , reverse the rest of them.
     * */
    //Method 3 implementation.
    //Strait forward,
    //Just notice that k might be greater than nums.length
    //So if k == nums.length, thats not rotating.
    //So we take k = k%nums.length if nums != null && nums.length != 0.
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return ;
        k = k % nums.length;
        if(k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
