package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2016/7/18.
 */
public class MaximumProductSubarray {

    //time exceed limit
    public int maxProduct(int[] nums) {
        int demention = nums.length;
        if(demention == 1){
            return nums[0];
        }
        int[][] result = new int[demention+1][demention+1];
        int max = 0;
        for(int i = 0; i < demention+1; i++){
            Arrays.fill(result[i], 1);
        }
        for(int i = 1; i < demention+1; i++){
            for(int j = i ; j < demention+1; j++){
                result[i][j] = result[i][j-1]*nums[j-1];
                if(max < result[i][j]){
                    max = result[i][j];
                }
            }
        }
        return max;
    }

    //fast
    //Almost the same as max Sum,
    //Because it was product, two negative can result in positive.
    //So need to maintain max and min for each index.
    public int maxProductFast(int[] nums) {
        int max[] = new int[nums.length];
        int min[] = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){

            int tempMaxProduct = nums[i] * max[i-1];
            int tempMinProduct = nums[i] * min[i-1];

            max[i] = Math.max(Math.max(nums[i], tempMaxProduct), tempMinProduct);
            min[i] = Math.min(Math.min(nums[i], tempMaxProduct), tempMinProduct);

            result = Math.max(max[i], result);
        }
        return result;
    }


    public static void main(String[] args){
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] test = {-4,-3};
        int result= mps.maxProduct(test);
    }

}
