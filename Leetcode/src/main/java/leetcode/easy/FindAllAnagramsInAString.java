package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/23.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0) return result;
        int start = 0, end = 0, len = p.length();
        int[] count = new int[256];
        for(char c : p.toCharArray()) count[c] ++;

        /**
         * Sliding window idea, but need practise to get it right.
         * Only knows the idea,
         * implementation always miss details.
         *
         * basically, couple of notes:
         * 1. Only decrease length, if it exists in p.
         * 2. always reduce count. becuase this will indicate if it appears in p, if it is negative, means it is not in p.
         * 3. always increase end.
         * 4. once len == 0, start is one of the result
         * 5. All happen in one loop, and after we increase end, end - start is bigger than the length of p.
         *   (This part happens the check in same loop, but after we increase end.)
         *   means if current window length is greater than p.length(), we move start to make it the window size again.
         *   then check if current window is valid in the next loop.
         *  　we move start,
         *      1. only increase len if start is in p.
         *         meaning only if count >= 0, it means start is in p.
         *      2. always increase count.
         *      3. always increase start.
         *
         * */
        while(end < s.length()){
            char c = s.charAt(end);
            if(count[c] > 0)
                len--;
            count[c] --;
            end ++;
            if(len == 0) result.add(start);
            if(end - start == p.length()){
                if(count[s.charAt(start)] >= 0)
                    len++;
                count[s.charAt(start)] ++;
                start ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString fais = new FindAllAnagramsInAString();
        fais.findAnagrams(s,p);
    }
}
