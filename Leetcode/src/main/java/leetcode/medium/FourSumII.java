package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/1.
 */
public class FourSumII{
    /**
     * O(n^2) time complexity
     * Separate them into two groups
     * */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        //Key is the sum, value is the count of this sum
        Map<Integer, Integer> ABSum = new HashMap<Integer, Integer>();
        for(int a : A){
            for(int b: B){
                ABSum.put(a+b, ABSum.getOrDefault(a+b,0)+1);
            }
        }

        int result = 0;
        for(int c : C){
            for(int d : D){
                result += ABSum.getOrDefault(-1*(c + d),0);
            }
        }
        return result;
    }
}
