package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/6.
 */
public class ContinuousSubarraySum {

    //Use a map to keep track remaining and corresponding index.
    //if any future index that has the same remaining,
    //which means from that index to this current index, the sum module k is 0
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> track = new HashMap<Integer, Integer>();
        //initialize with remaining 0 and index -1;
        track.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(k != 0) sum = sum % k;
            Integer previousIndex = track.get(sum);
            //Here is a if-else condition
            //if not null, we see how long the subarray is, if it is greater than 2, we return.
            if(previousIndex != null){
                //Since the sub-array need at least two elements.
                if(i - previousIndex > 1) return true;
            }
            //only if it is null, we add new index to it.
            //otherwise, we wont change the index, which is the first time we get this remaining.
            else track.put(sum,i);
        }
        return false;
    }

}
