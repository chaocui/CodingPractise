package leetcode.easy;

import java.util.*;

/**
 * Created by cc on 2017/4/20.
 */
public class KdiffPairsInAnArray {

    /**
     * Idea is simple.
     * Use a map
     * key is num[i] + k. value is count of this value.
     * The reason of using map and keep the count is for k = 0;
     * if k == 0, we loop through map, see how many keys has count > 1.
     *
     * If k != 0,
     * we dont use the value part at all.
     * all we do is
     * traverse the array,
     * if the current array value is in map as key, we increase result and remove the key.
     *
     * Reason is:
     * we only need unique pairs(array may has dups. so if we have two 5s,
     * first 5 in use with previous number, then the second 5 just ignore it.)
     *
     * */
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int result = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> dict = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            dict.put(nums[i] + k, dict.getOrDefault(nums[i]+k,0)+1);
        }
        if(k == 0){
            for(Map.Entry<Integer, Integer> each : dict.entrySet())
                if(each.getValue() > 1) result ++;
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            if(dict.remove(nums[i]) != null)
                result ++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,4,5};
        KdiffPairsInAnArray kpia = new KdiffPairsInAnArray();
        System.out.println(kpia.findPairs(nums,0));
    }

}
