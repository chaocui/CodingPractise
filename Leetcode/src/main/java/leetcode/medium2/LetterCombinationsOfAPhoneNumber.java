package leetcode.medium2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/29.
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * Non-recursive solution
     * Just starting from right to left.
     * accumulating results.
     * */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        Map<String, String> dict = new HashMap<>();
        dict.put("2","abc");
        dict.put("3","def");
        dict.put("4","ghi");
        dict.put("5","jkl");
        dict.put("6","mno");
        dict.put("7","pqrs");
        dict.put("8","tuv");
        dict.put("9","wxyz");
        dict.put("0"," ");
        for(int i = digits.length() - 1; i >= 0; i--){
            String d = digits.charAt(i)+"";
            if(dict.containsKey(d)){
                List<String> resultCopy = new ArrayList<>(result);
                result.clear();
                String s = dict.get(d);
                for(char c : s.toCharArray()){
                    if(resultCopy.size() == 0)
                        result.add(c+"");
                    else {
                        for (int j = 0; j < resultCopy.size(); j++) {
                            result.add(c + resultCopy.get(j));
                        }
                    }
                }
            }
        }
        return result;
    }

    //Recursive solution is pretty straight forward.
    //Base case is the starting index reaching the length of string.
    //return empty.
    //otherwise, prepend current chars to result list.
    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsOfAPhoneNumber lcop = new LetterCombinationsOfAPhoneNumber();
        List<String> result = lcop.letterCombinations(digits);
        for(String s : result)
            System.out.println(s);
    }
}
