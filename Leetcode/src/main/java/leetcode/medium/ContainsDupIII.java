package leetcode.medium;

import java.util.TreeSet;

/**
 * Created by cc on 2016/7/16.
 */
public class ContainsDupIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
