package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2017/4/15.
 */
public class ConcatenatedWords {

    /**
     * Use a set to hold all the strings from words.
     *
     * Basic idea is the same as word break.
     * Loop through each word. use the list as dictionary, remove itself first.
     * then see if current word can be formed by other words.
     * if yes, add to result, otherwise next one.
     * */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordDict = new HashSet<>();
        /**
         * Since it says at least two shorter string,
         * we ignore empty string.
         * */
        for(String s : words){
            if(!s.equals("")) wordDict.add(s);
        }
        List<String> result = new ArrayList<>();
        for(String s : words){
            if(valid(s, wordDict))
                result.add(s);
        }
        return result;
    }

    public boolean valid(String s, Set<String> wordDict){

        //if s is empty, definately return false. cannot get two shorter that form s.
        if(s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        wordDict.remove(s);
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                //j is both length and index.
                //substring(j,i) j is index.
                //dp[j] j is length. j index j+1 length previous length j + 1 - 1 = j.
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        wordDict.add(s);
        return dp[s.length()];
    }

}
