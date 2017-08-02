package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2016/11/1.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return breakWord(s, wordDict);
    }

    private List<String> breakWord(String s, Set<String> wordDict){

        List<String> result = new ArrayList<String>();
        if(s.length() == 0){
            result.add("");
            return result;
        }
        for(String each : wordDict){

            if(s.startsWith(each)){
                String remain = s.substring(each.length());
                List<String> breakRemain = breakWord(remain, wordDict);
                for(String e : breakRemain){
                    String eachResult = "";
                    if(e.length() == 0){
                        eachResult = each;
                    }
                    else{
                        eachResult = each + " " + e;
                    }
                    result.add(eachResult);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        WordBreakII wb2 = new WordBreakII();
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("sand");
        dict.add("and");
        dict.add("dog");
        List<String> result = wb2.wordBreak("catsanddog",dict);

        for(String s : result){
            System.out.println(s);
        }
    }

}
