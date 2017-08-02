package leetcode.Facebook;

/**
 * Created by cc on 2017/5/30.
 */
public class RotateArray {

    /**
     * Tricky idea.
     * With extra space. concatenate, then take from n-k to n-k+n substring of the concatenate one.
     * Without extra space, in place method.
     * 1. reverse array,
     * 2. reverse 0 to k-1;
     * 3. reverse k to length - 1.
     * */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if(k == 0) return;
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end --;
        }
    }
}
