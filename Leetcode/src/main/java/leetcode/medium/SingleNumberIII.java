package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2016/7/16.
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums){

        int[] result = new int[2];
        int interResult = 0;
        for(int num : nums){
            interResult ^= num;
        }

        interResult = interResult & ((~interResult) + 1);
        for(int num : nums){
            if((num & interResult) == 0){
                result[0] = result[0] ^ num;
            }
            else{
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }

}
