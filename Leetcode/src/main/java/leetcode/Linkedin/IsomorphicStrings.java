package leetcode.Linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/7/31.
 */
public class IsomorphicStrings {

    /**
     * Faster neat solution.
     * use 512 size array.
     * first 256 stores index of chars in s
     * second 256 stores index of chars in t
     * so we map like this
     * assign them with the same index.
     * array[c1] = array[c2+256] = i;
     *
     * if(for new character)
     * index is not equal
     * 1 initially, they are equal both -1;
     * 2 after loop each character, mappings assign to same index.
     *      if not equal,
     *      1. mapping not the same.
     *      2. different character map to different indexes.
     * */
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[512];
        Arrays.fill(map, -1);
        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i)] != map[t.charAt(i)+256]) return false;
            map[s.charAt(i)] = map[t.charAt(i)+256] = i;
        }
        return true;
    }

}
