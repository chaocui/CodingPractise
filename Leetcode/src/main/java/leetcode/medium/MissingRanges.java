package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/5/17.
 */
public class MissingRanges {

    /**
     *  Basic idea is:
     *  Keep track of lower bound
     *  if lower bound is equal with current number in num
     *  increase lower bound by 1 and continue;
     *  if smaller, then put lower -> num - 1 or lower if lower = num - 1;
     *  update lower = num + 1 as the new lower
     *
     *  at the end, check if lower reach upper, if not, same logic add lower -> upper.
     *  otherwise, just return.
     * */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        long l = lower, u = upper;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == l){
                l++;
                continue;
            }
            if(l < nums[i]){
                StringBuilder sb = new StringBuilder();
                if(l + 1 == nums[i]) sb.append(l);
                else sb.append(l).append("->").append(nums[i]-1);
                l = (long)nums[i] + 1;
                result.add(sb.toString());
            }
        }
        if(l <= u - 1)
            result.add(l + "->" + u);
        if(l == u)
            result.add(l+"");
        return result;
    }

    public static void main(String[] args) {
        int[] test = {2147483647};
        MissingRanges mr = new MissingRanges();
        mr.findMissingRanges(test, 0,2147483647);
    }
}
