package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/21.
 */
public class ContiansDuplicatII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(dict.containsKey(nums[i])){
                int index = dict.get(nums[i]);
                if(i - index <= k) return true;
            }
            //if not find, then we update index to current one.
            //Since next dup only need to calculate the distance between
            //itself and current index.
            //it will be longer with the previous index.
            dict.put(nums[i],i);
        }
        return false;
    }
}
