package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/6/10.
 */
public class GroupShiftedStrings {

    /**
     * Basic idea,
     * Key is string length, distance between each char.
     * same key goes to same value.
     *
     * When calculate distance between chars, +26%26.
     *
     * Key part of this issue is that
     * 1. same length may have different interval length, that will be two groups.
     * 2. So we need to make key that combine string length and character distances.
     * 3. When calculate distance, we need to consider next value always greater than previous one.
     * we done so by add 26 to the current character then minus.
     * */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strings){
            String key = s.length() + "_" + getDistance(s);
            if(result.containsKey(key))
                result.get(key).add(s);
            else{
                ArrayList<String> l = new ArrayList<>();
                l.add(s);
                result.put(key, l);
            }
        }
        return new ArrayList<>(result.values());
    }

    public String getDistance(String s){
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < s.length(); i++)
            result.append((s.charAt(i)-s.charAt(i-1)+26)%26).append("_");
        return result.toString();
    }
}
