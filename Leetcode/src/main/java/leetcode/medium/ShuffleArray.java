package leetcode.medium;

import java.util.Random;

/**
 * Created by cc on 2017/2/1.
 */
public class ShuffleArray {

    int[] nums;
    Random r;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = nums.clone();
        //If j starting from 0;
        //when j = 0; i is r.next(1), means that i always 0 when j = 0;
        //So there is no swap, so dont need to start at j = 0, but even start at j = 0, still correct.
        for(int j = 1; j < nums.length; j++){
            int i = r.nextInt(j+1);
            swap(result, i, j);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
