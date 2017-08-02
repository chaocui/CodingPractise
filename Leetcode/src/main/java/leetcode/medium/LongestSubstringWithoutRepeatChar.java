package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/7/24.
 */
public class LongestSubstringWithoutRepeatChar {

    /*
    * Note:
    * 1. select start, if get duplicate from previous chars,
    * update start with the max(currentStart, previousCharPosition+1);
    * eg: abbaefg. If dups is found in range smaller than current start.
    * Which means there are already dups found before. don't update start.
    * So we update start as max(current, dupPosition+1); Always take the bigger one.
    *
    * 2. Once reach the end, use length - start to get the last non-repeat section.
    * then compare with current result.
    * */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer>  trace = new HashMap();
        int start = 0;
        int end = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(trace.containsKey(c)){
                end = i - 1;
                result = Math.max(result, end - start + 1);
                start = Math.max(trace.get(c) + 1, start);
            }
            //always put c and index in trace
            //If not contain, add it, it contain, update latest index
            trace.put(c, i);
        }
        result = Math.max(result, s.length() - start);
        return result;
    }
}
