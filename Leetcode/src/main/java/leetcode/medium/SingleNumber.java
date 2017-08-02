package leetcode.medium;

/**
 * Created by cc on 2016/7/15.
 */
public class SingleNumber {

    public int solution(int[] nums){
        //"XOR with 0 is the same number"
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

}
