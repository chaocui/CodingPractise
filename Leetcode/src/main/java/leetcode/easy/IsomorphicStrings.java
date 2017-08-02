package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/23.
 */
public class IsomorphicStrings {

    /**
     * basic idea is use 512 size array to keep track of last show up position
     * first half 256 for s1, second half 256 for s2.
     * if last show up location is not the same, then return false.
     * otherwise, update location.
     *
     * Initialize as -1 is because 0 is also a position.
     * or we can use i+1 as position.
     * */
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        Arrays.fill(m,-1);
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "aa";

        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic(s1,s2));
    }

/*
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Integer> pos1 = new HashMap<Character, Integer>();
        Map<Character, Integer> pos2 = new HashMap<Character, Integer>();

        for(long i = 0; i < s.length(); i++){
            char c1 = s.charAt((int)i);
            char c2 = t.charAt((int)i);
            if(!pos1.containsKey(c1) && !pos2.containsKey(c2)){
                pos1.put(c1,i);
                pos2.put(c2,i);
            }
            else if(pos1.containsKey(c1) && pos2.containsKey(c2) && pos1.get(c1) == pos2.get(c2)){
                pos1.put(c1,i);
                pos2.put(c2,i);
            }
            else return false;
        }
        return true;
    }
*/
}
