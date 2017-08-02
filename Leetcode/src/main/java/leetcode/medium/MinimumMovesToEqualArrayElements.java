package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/1/24.
 */
public class MinimumMovesToEqualArrayElements {

    //Instead of sort, we can use quick select find the medium number.
    //Which is the length/2 smallest number in the array.
    //QuickSelect!!!
    public int minMoves2(int[] nums) {
        //sort, then all change to the middle element.
        Arrays.sort(nums);
        int length = nums.length;
        if(length < 2){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < length; i++){
            result += Math.abs((nums[i] - nums[length/2]));
        }
        return result;
    }

    public static void main(String[] args){
        MinimumMovesToEqualArrayElements mmteae = new MinimumMovesToEqualArrayElements();
        int[] test = {1,2,3};
        System.out.println(mmteae.minMoves2(test));
    }

}
