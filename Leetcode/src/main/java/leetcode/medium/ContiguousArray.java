package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/3/7.
 */
public class ContiguousArray {

    //Basic idea. Change all 0s in nums to -1s
    //So that when we add them up, we track each sum, is from 0 to which index.
    //for example. -1 1 1 1 1 1 1 -1 -1.
    //first 5 elements add to 3, current index is 4.
    //all elements add to 3 also, current index is length - 1;
    //So we know that from 4 to the end, the sum is 0, which means it has even number of 0s and 1s.
    //So we compare this length with the current max.
    //finally we return max.


    //用HASHMAP 记录每个sum的end position.
    //当我们再次得到sum的时候， current position - 哈希表里的position就是０跟1出现相同次数的长度。
    //用当前最大长度跟我们这次得到的长度比较 取较大值。
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        tracker.put(0,-1);
        int max = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(tracker.containsKey(sum)){
                max = Math.max(max, i - tracker.get(sum));
            }
            else{
                tracker.put(sum, i);
            }
        }
        return max;
    }

}
