package leetcode.medium;

import java.util.List;

/**
 * Created by cc on 2017/4/15.
 */
public class WordBreak2 {
    //DP
    public boolean wordBreak(String s, List<String> wordDict){

        /**
         * Can be understand in this way.
         * the index in dp indicates the length .
         * means that length i string can be formed by wordDict.
         *
         * so dp[0] always true.
         * substring(j,i), substring from index j.
         * its corresponding length of index j is j + 1.
         * so the previous length of index j is j + 1 - 1 which is j.
         *
         * for instance. index 1 has length 2. previous length is 2 - 1 is 1.
         *
         * Just keep in mind, dp index indicate the length.
         * */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
