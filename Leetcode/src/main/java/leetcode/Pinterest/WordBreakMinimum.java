package leetcode.Pinterest;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by cc on 2017/6/20.
 */
public class WordBreakMinimum {

    public int minimumBreak(Set<String> dict, String s){
        //count indicates that from 0 to index(exclusive), minimum string we need to construct s.
        int[] count = new int[s.length()+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 1;

        //outer loop, from i to s.length
        //inner loop, loop through j from 0 to i.
        //if substring j to i is in dict, then dp[j] + 1 is the ways from 0 to i.
        //we take dp[i] = min(dp[i], dp[j]+1);
        for(int i = 1; i < count.length; i++){
            for(int j = 0; j < i; j++){
                String remainingWord = s.substring(j, i);
                if(count[j] != Integer.MAX_VALUE && dict.contains(remainingWord)){
                    count[i] = Math.min(count[i], count[j] + 1);
                }
            }
        }
        return count[s.length()];
    }
}
