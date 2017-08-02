package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/2/14.
 */
public class WordBreak {
    //Recursive solution will Timeout. Use DP.
    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        for(int i = 1; i <= s.length(); i++){
            String currentString = s.substring(0,i);
            if(contains(currentString, wordDict) && wordBreak1(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }

    private boolean contains(String s, List<String> wordDict){
        for(String each : wordDict){
            if(s.equals(each)) return true;
        }
        return false;
    }

    //basic dp idea
    //1 demantion is enough, dp[j] = for(int i = j; i>=0; i--) dp[i] && contains(s.substring(i,j+1));
    public boolean wordBreak(String s, List<String> wordDict){
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i; j >= 1; j--){
                String temp = s.substring(j-1,i);
                if(contains(temp, wordDict) && dp[j-1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }


    public static void main(String[] args){
        List<String> test = new ArrayList<String>();
        test.add("aaaa");
        test.add("aaa");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("aaaaaaa", test));
    }

}
