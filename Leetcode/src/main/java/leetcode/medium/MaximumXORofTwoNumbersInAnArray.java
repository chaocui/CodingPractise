package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/3/29.
 */
public class MaximumXORofTwoNumbersInAnArray {
    /**
     * I dont think i can remember this after 2 hours. LOL
     * */
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | 1 << i;
            Set<Integer> prefix = new HashSet<Integer>();
            for(int num : nums)
                //discard right i digits
                prefix.add(num & mask);

            //new max should have a 1 at the i-th position from right.
            int temp = max | 1 << i;
            for(int each : prefix){
                if(prefix.contains(temp ^ each))
                    max = temp;
            }
        }
        return max;
    }
}
