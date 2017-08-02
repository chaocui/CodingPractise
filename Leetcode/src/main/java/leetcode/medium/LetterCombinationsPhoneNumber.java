package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/2/4.
 */
public class LetterCombinationsPhoneNumber {

    //recursion
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        return getCombinations(0,digits);
    }

    private List<String> getCombinations(int i, String digits){
        if(i == digits.length()){
            List<String> r = new ArrayList<String>();
            r.add("");
            return r;
        }
        Map<Character, String> dict = new HashMap<Character, String>();
        dict.put('2',"abc");
        dict.put('3',"def");
        dict.put('4',"ghi");
        dict.put('5',"jkl");
        dict.put('6',"mno");
        dict.put('7',"pqrs");
        dict.put('8',"tuv");
        dict.put('9',"wxyz");
        char c = digits.charAt(i);
        String s = dict.get(c);
        List<String> nextResult = getCombinations(i+1,digits);
        List<String> result = new ArrayList<String>();
        for(int m = 0; m < nextResult.size(); m++){
            String eachTempResult = nextResult.get(m);
            for(int n = 0; n < s.length(); n++){
                char tempC = s.charAt(n);
                result.add(tempC+eachTempResult);
            }
        }
        return result;
    }
}
