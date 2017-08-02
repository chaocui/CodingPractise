package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/4/6.
 */
public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        Map<String, Integer> count = new HashMap<>();
        for(String s: strs){
            for(String each : getSubsequence(s)){
                count.put(each, count.getOrDefault(each,0)+1);
            }
        }
        int result = -1;
        for(Map.Entry<String,Integer> each : count.entrySet()){
            if(each.getValue() == 1){
                result = Math.max(result, each.getKey().length());
            }
        }
        return result;
    }


    private Set<String> getSubsequence(String s){
        Set<String> result = new HashSet<String>();
        if(s.length() == 0){
            result.add("");
            return result;
        }
        Set<String> temp = getSubsequence(s.substring(1));
        //Add all result without first char,
        result.addAll(temp);
        //add first char to each of the result to form new results.
        for(String each : temp){
            result.add(s.charAt(0) + each);
        }
        return result;
    }

}
