package leetcode.Facebook;

/**
 * Created by cc on 2017/6/4.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int head = 0, length = Integer.MAX_VALUE, count = t.length(), start = 0, end = 0;
        int[] track = new int[256];
        for(char c : t.toCharArray())
            track[c]++;
        while(end < s.length()){
            char c = s.charAt(end);
            if(track[c] > 0) count --;
            track[c]--;
            end ++;

            //Sliding window idea.
            //Moving left/start boundary condition is a little special.
            //If count == 0 we just move start, until we increase count.
            //start now will be the index that on the right the character that increase count.
            while(count == 0) {
                if(end - start < length){
                    length = end - start;
                    head = start;
                }
                char c1 = s.charAt(start);
                if(track[c1] == 0) count++;
                track[c1]++;
                start++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(head, head + length);
    }
}
