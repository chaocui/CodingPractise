package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/28.
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '*' || c == '+'){
                String firstPart = input.substring(0,i);
                String secondPart = input.substring(i+1);
                List<Integer> result1 = diffWaysToCompute(firstPart);
                List<Integer> result2 = diffWaysToCompute(secondPart);
                for(Integer r1 : result1){
                    for(Integer r2 : result2){
                        int tempResult = 0;
                        if(c == '-') tempResult = r1-r2;
                        if(c == '+') tempResult = r1+r2;
                        if(c == '*') tempResult = r1*r2;
                        result.add(tempResult);
                    }
                }
            }
        }
        //base case
        //if there is operator in the sequence, then it is a number, just put it in result.
        if(result.size() == 0) result.add(Integer.parseInt(input));
        return result;
    }

}
