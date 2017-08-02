package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/5/21.
 */

public class SplitArrayWithEqualSum {

    /**
     * Brute force, TLE
     * */
    int[] sum;
    public boolean splitArray1(int[] nums) {
        sum = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++)
            sum[i] = sum[i-1] + nums[i-1];

        //at least 6 elements, otherwise, not possible.
        for(int i = 1; i < nums.length - 5; i++){
            int sum1 = getSum(0,i-1);
            for(int j = i + 2; j < nums.length - 3; j ++){
                if(getSum(i+1, j-1) == sum1){
                    for(int m = j + 2; m < nums.length - 1; m++){
                        if(getSum(j+1, m-1) == sum1){
                            if(getSum(m+1, nums.length-1) == sum1)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public int getSum(int start, int end){
        return sum[end+1] - sum[start];
    }

    //Basically, just divide and conquer.
    //Since four portions, j is the middle cut,
    //i is left cut, k is right cut. So cut in middle first.
    //find all possible equal cuts in left, put the sum in hashSet.
    //find all possible cuts in right, if sum is in hashset, return true.
    //otherwise return false.
    public boolean splitArray(int[] nums) {
        //at least 6 numbers
        if(nums.length < 7) return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sum[i] = sum[i-1] + nums[i];

        //j is at least 3. and less than nums.length - 3;
        for(int j = 3; j < nums.length - 3; j++){
            //for each middle cut, we need a new hashset.
            Set<Integer> track = new HashSet<>();
            for(int i = 1; i < j-1; i++){
                if(sum[i-1] == sum[j-1] - sum[i]) track.add(sum[i-1]);
            }

            for(int k = j + 2; k < nums.length - 1; k++){
                if(sum[k-1] - sum[j] == sum[nums.length - 1] - sum[k] && track.contains(sum[k-1]-sum[j]))
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] test = {1,2,1,2,1,2,1,11};
        SplitArrayWithEqualSum sawes = new SplitArrayWithEqualSum();
        System.out.println(sawes.splitArray(test));
    }

}
