package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/1/31.
 */
public class NextPermutation {
    //Basic idea
    //loop through right to left.
    //keep track of maximum of right side.
    //if current greater than maximum, continue;
    //else loop through, right side. find the minimum which greater than current.
    //switch these two. reverse i+1 to the end.
    public void nextPermutation(int[] nums) {
        int rightMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= rightMax) {
                rightMax = nums[i];
                continue;
            } else {
                for (int j = nums.length - 1; j > i; j--) {
                    //swap
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

    public static void main(String[] args){
        int[] test = {1,3,2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

}
