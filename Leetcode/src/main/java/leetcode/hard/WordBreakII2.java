package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/12.
 */
public class WordBreakII2 {

    /**
     * Just a basic recursive question.
     *
     * Loop through whole string,
     * any prefix exists in wordDict, recursively do the rest of the string,
     * and prepend the current word to the result.
     *
     * In order to make it faster, we use a memory,
     * to keep track of for a certain string, the result we already have. So we can avoid recalculation.
     *
     * Usually, top bottom recursion use memory works.
     * */
    Map<String, List<String>> memory = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(memory.containsKey(s)) return memory.get(s);
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= s.length(); i ++){
            String word = s.substring(0,i);
            if(wordDict.contains(word)){
                List<String> tempResult = wordBreak(s.substring(i), wordDict);
                if(tempResult.size() != 0){
                    for(int j = 0; j < tempResult.size(); j++){
                        String each = word + " " + tempResult.get(j);
                        result.add(each);
                    }
                }
                else if(i == s.length())
                    result.add(word);
            }
        }
        memory.put(s, result);
        return result;
    }

}
