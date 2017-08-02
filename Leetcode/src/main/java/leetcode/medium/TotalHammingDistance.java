package leetcode.medium;

/**
 * Created by cc on 2017/3/30.
 */
public class TotalHammingDistance {

    //For each position, count the number of ones in the array.
    //k 1s, n - k 0s, so that it contributes to k*(n-k) different number combinations for that position..

    /**
     * Basic idea is no thinking based on two numbers.
     * Thinking based on each position.
     * For each position, we calculate how many different number combinations has different bits.
     * */
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for(int i = 0; i <= 31; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count = count + ((nums[j] >> i) & 1);
            }
            //for each position, it contributes to this many number combinations.
            result += count * (nums.length - count);
        }
        return result;
    }

    public int totalHammingDistance1(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                result += countOnes(nums[i]^nums[j]);
            }
        }
        return result;
    }

    private int countOnes(int num){
        int result = 0;
        while(num != 0){
            result += num & 1;
            num = num >> 1;
        }
        return result;
    }

}
