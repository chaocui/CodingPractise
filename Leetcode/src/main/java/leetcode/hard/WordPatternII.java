package leetcode.hard;

import leetcode.easy.WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/6/10.
 */
public class WordPatternII {

    /**
     * Back tracing.
     *
     * Couple key points.
     * 1. use set to track existing match, different character cannot match to same string.
     * 2. base case, if all reach the end, return true.
     *               if only one reach the end, return false.
     * 3. typical back tracing.
     *    check all possibility, then remove from map and set,
     *    if we found result, just return true.
     *
     * */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> dict = new HashMap<>();
        Set<String> existingMatch = new HashSet<>();
        return getResult(dict, existingMatch, str, pattern, 0);
    }

    public boolean getResult(Map<Character, String> dict, Set<String> existingMatch, String s, String pattern, int pIndex){
        if(pIndex == pattern.length() && s.length() == 0) return true;
        if(pIndex == pattern.length() || s.length() == 0) return false;
        char p = pattern.charAt(pIndex);
        if(dict.containsKey(p)){
            String tempPattern = dict.get(p);
            if(s.startsWith(tempPattern) || s.equals(tempPattern)){
                return getResult(dict, existingMatch, s.substring(tempPattern.length()), pattern, pIndex+1);
            }
            return false;
        }
        else{
            for(int i = 0; i < s.length(); i++){
                String tempPattern = s.substring(0,i+1);
                if(existingMatch.contains(tempPattern)) continue;
                dict.put(p, tempPattern);
                existingMatch.add(tempPattern);
                if(getResult(dict, existingMatch, s.substring(i+1), pattern, pIndex+1))
                    return true;
                dict.remove(p);
                existingMatch.remove(tempPattern);
            }
        }
        //never gets to this part of code, or can remove the return false in first if will gets here.
        return false;
    }

    public static void main(String[] args) {
        WordPatternII wp2 = new WordPatternII();
        System.out.println(wp2.wordPatternMatch("itwasthebestoftimes","ittwaastthhebesttoofttimesss"));
    }

}
