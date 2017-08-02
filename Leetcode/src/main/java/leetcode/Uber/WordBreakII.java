package leetcode.Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/6/21.
 */
public class WordBreakII {


    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= s.length(); i++){
            String current = s.substring(0,i);
            if(wordDict.contains(current)){
                List<String> tempResult = wordBreak(s.substring(i),wordDict);
                if(tempResult.size() != 0) {
                    for (String each : tempResult) {
                        String temp = current + " " + each;
                        result.add(temp);
                    }
                }
                //if only one word till the end, wordBreak return empty list.
                //we just add current word to result.
                else if(i == s.length())
                    result.add(current);
            }
        }
        cache.put(s,result);
        return result;
    }

}
