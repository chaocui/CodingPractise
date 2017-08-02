package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/21.
 */
public class WordPattern {

    /**
     * if contains char but value not match, return false.
     * if not contains char, but value already exist, return false.
     * otherwise, we just put char and string into map.
     * */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> dict = new HashMap<Character, String>();
        String[] sL = str.split(" ");
        if(pattern.length() != sL.length) return false;
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String s = sL[i];
            if(dict.containsKey(c) && !dict.get(c).equals(s))
                return false;
            else if(!dict.containsKey(c) && dict.containsValue(s))
                return false;
            dict.put(c,s);
        }
        return true;
    }
}
