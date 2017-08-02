package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by cc on 2016/7/24.
 */
public class ContainsDuplicatesIII {
    //Hash Set;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(k < 0 || t < 0 || nums.length < 1){
            return false;
        }
        //Since negative numbers are allowed.
        //To avoid -2 and 2 go in to the same bucket. we need to reposition to all negative or positive.

        //Since for every i, we are processing it immediately,
        //If satisfy, it will return.
        //If not, means that this new value does not fit in same bucket, in adjacent bucket, it does not satisfy diff <= t.
        HashMap<Long, Long> dic = new HashMap<Long, Long>();
        for(int i = 0; i < nums.length; i++) {
            long value = (nums[i] - Integer.MIN_VALUE) / Math.max(1, t);
            for (int j = -1; j < 2; j++) {
                if (dic.containsKey(value + j) && Math.abs(dic.get(value + j) - nums[i]) <= t) {
                    return true;
                }
            }
            dic.put(value, (long)nums[i]);
            if (i >= k) {
                long value1 = (nums[i - k] - Integer.MIN_VALUE) / Math.max(1, t);
                dic.remove(value1);
            }
        }
        return false;
    }

    //Tree Set
    public boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        TreeSet<Integer> dic = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(dic.floor(value) != null && dic.floor(value)+t >= value ||
                    dic.ceiling(value) != null && dic.ceiling(value) <= value + t){
                return true;
            }
            if(i > k){
                dic.remove(value);
            }
        }
        return false;
    }
}
