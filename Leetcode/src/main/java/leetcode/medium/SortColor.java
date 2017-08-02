package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/2/9.
 */
public class SortColor {

    //Basic idea, keep position of 0s and 2s.
    //Move 2s to the end, reduce position of 2
    //Move 0s to the beginning, increase position of 0.
    //loop till the position of 2. since after that that will be all 2s.
    public void sortColors(int[] nums) {
        int length = nums.length;
        int index0 = 0, index2 = length - 1;
        for(int i = 0; i <= index2; i++){
            if(nums[i] == 0 && i > index0){
                swap(nums,index0,i);
                i--;
                index0++;
            }
            else if(nums[i] == 2 && i < index2) {
                swap(nums, index2, i);
                i--;
                index2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] test = {1,0};
        SortColor sc = new SortColor();
        sc.sortColors(test);
        System.out.println(Arrays.toString(test));
    }

}
