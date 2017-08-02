package leetcode.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/5/31.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for(String s : strs){
            String key = generateKey(s);
            List<String> l = dict.getOrDefault(key, new ArrayList<>());
            l.add(s);
            dict.put(key,l);
        }
        return new ArrayList<>(dict.values());
    }

    public String generateKey(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray())
            count[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; i++)
            sb.append(count[i]).append('a'+i);
        return sb.toString();
    }

}
