package leetcode.Uber;

import java.util.List;

/**
 * Created by cc on 2017/6/21.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        //empty always breakable? this is because from j to i is one word, so 0 length is true.
        //dp[i] means that from 0 to i, is breakable, i exclusive.
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            //j less than i to make sure there are at least one character.
            for(int j = 0; j < i; j++){
                String currentS = s.substring(j,i);
                if(dp[j] && wordDict.contains(currentS)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    //Time limit exceed.
    public boolean wordBreak1(String s, List<String> wordDict){
        if(s.length() == 0) return true;
        for(int i = 1; i <= s.length(); i++){
            String currentS = s.substring(0,i);
            if(wordDict.contains(currentS)&&wordBreak1(s.substring(i), wordDict))
                return true;
        }
        return false;
    }

}
