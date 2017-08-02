package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/5/17.
 */
public class UniqueWordAbbreviation {

    //The key part is understand the question
    Map<String, String> dict = new HashMap();
    public UniqueWordAbbreviation(String[] dictionary) {
        for(String s : dictionary){
            String key = getKey(s);
            if(dict.containsKey(key)){
                //if two different word has the same key, then it will be invalid key
                if(!dict.get(key).equals(s))
                    dict.put(key,"");
            }
            else
                dict.put(key,s);
        }
    }

    public boolean isUnique(String word) {
        if(word == null || word.length() == 0) return false;
        return !dict.containsKey(getKey(word))||dict.get(getKey(word)).equals(word);
    }

    private String getKey(String s){
        if(s.length() <= 2) return s;
        return ""+s.charAt(0)+s.charAt(s.length() - 1) + s.length();
    }

}
