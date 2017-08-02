package leetcode.hard;

/**
 * Created by cc on 2017/3/25.
 */
public class LongestRepeatingCharacterReplacement {
    /**
     * Basic idea,
     * sliding window, extend end,
     * while not satisfying condition, move start to right.
     * */
    public int characterReplacement(String s, int k) {
        int maxCount = 0, maxLength = 0, start = 0, end = 0;
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c-'A']);
            while(end - start + 1 - maxCount > k){
                count[s.charAt(start) - 'A'] --;
                start ++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end ++;
        }
        return maxLength;
    }

}
