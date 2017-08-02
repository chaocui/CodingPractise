package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/5/23.
 */
public class MaximumSizeSubarraySumEqualsK {

    //use hashmap keep track of sum from 0 to i.
    //key is the sum, value is the index.
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0,sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) max = i+1;
            //if contains this value, then means map.get(sum-k) + 1 to i sum to k
            else if(map.containsKey(sum - k)) max = Math.max(max, i-map.get(sum-k));
            //since we need the longest,
            //if there is already sum in map, means existing index is smaller.
            //when substract this index, will result in larger length.
            //so only if there is no sum existing, we put, if there is, we dont update.
            //also sum == k is checked before, we won't miss from 0 to this index i length.
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }

}
