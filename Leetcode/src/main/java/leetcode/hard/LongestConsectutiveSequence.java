package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2016/11/13.
 */
public class LongestConsectutiveSequence {
    /**
     * Basic idea,
     * Put all integers into a set.
     * Loop through the array
     * for each one, see if its -i， +i is in set, at the same time increase the count
     * if they are in, remove them to avoid visit twice.
     * Until its empty or reach the end of nums.
     * This works, because, if one number can be reached starting from other number, vise versa.
     * So no need to traverse twice.
     * */
    public int longestConsecutive(int[] nums) {
        Set<Integer> dict = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            dict.add(nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(dict.isEmpty()){
                break;
            }
            int num = nums[i];
            int j = 1;
            int count = 1;
            dict.remove(num);
            //increase this number, see if it is in dict, if yes, increase count, keep going,
            //if not break;
            while(true){
                if(dict.contains(num+1)){
                    count ++;
                    dict.remove(num+1);
                    num++;
                }
                else{
                    break;
                }
            }

            num = nums[i];
            //same logic above, just decrease.
            while(true){
                if(dict.contains(num-1)){
                    count ++;
                    dict.remove(num-1);
                    num--;
                }
                else{
                    break;
                }
            }
            //Compare the current result with this loop's maximum
            result = Math.max(result, count);
        }
        return result;
    }
}
