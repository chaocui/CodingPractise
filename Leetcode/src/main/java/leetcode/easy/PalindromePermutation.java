package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/6/10.
 */
public class PalindromePermutation {
    /**
     * Use set,
     * if it is in it.
     * remove, if not , add it.
     * if set size is > 1, return false.
     * */
    public boolean canPermutePalindrome(String s) {
        Set<Character> track = new HashSet<>();
        for(char c : s.toCharArray()){
            if(track.contains(c))
                track.remove(c);
            else
                track.add(c);
        }
        return track.size() <= 1;
    }

}
