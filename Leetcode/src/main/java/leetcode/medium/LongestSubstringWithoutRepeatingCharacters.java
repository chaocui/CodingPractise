package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/5/3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Sliding window should work.
     * */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> track = new HashMap<>();
        int start = 0, end = 0, result = 1;
        while(end < s.length()){
            char c = s.charAt(end);
            if(track.containsKey(c)){
                result = Math.max(result, end - start);
                //If the showed up position is before current start,
                //we keep current start. not updating. if we did, it will include dups.
                start = Math.max(track.get(c) + 1, start);
            }
            track.put(c, end);
            end++;
        }
        result = Math.max(result, end - start);
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbbb"));
    }

}
