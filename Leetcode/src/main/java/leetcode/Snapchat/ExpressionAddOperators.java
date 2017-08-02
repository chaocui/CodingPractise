package leetcode.Snapchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/17.
 */
public class ExpressionAddOperators {

    /**
     * String has all digits.
     * number can be more than 1 digit, so we need to consider all combinations starting form one position.
     * if number start as 0, only 1 digit is valid.
     *
     * Since multiply has higher priority than + and -, we need to keep track of what we added before.
     * so if we apply multiply, we substract that number and add that number multiply by current.
     * */
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        getResult(result, "", 0,0,0,target, num);
        return result;
    }

    public void getResult(List<String> result, String exp, long preValue, long preAdded, int start, int target, String num){
        //reach the end, if preValue == target, add to result, then return.
        if(start == num.length()){
            if(preValue == target)
                result.add(exp);
            return;
        }
        for(int i = start; i < num.length(); i++){
            //if current loop done, number will be more than one digit, and start as 0, which is not valid, we just break
            if( i != start && num.charAt(start) == '0') break;
            long currentVal = Long.parseLong(num.substring(start, i+1));
            //if start == 0, means there is nothing in expression now, we just append the number.
            if(start == 0){
                getResult(result, currentVal+"", currentVal, currentVal, i+1, target, num);
            }
            else{
                //handle +
                getResult(result, exp + "+" + currentVal, preValue + currentVal, currentVal, i+1, target, num);
                //handle -
                getResult(result, exp + "-" + currentVal, preValue - currentVal, -currentVal, i+1, target, num);
                //handle *
                /**
                 * Multiply will need the preAdded value, not for others, since others won't take higher priority.
                 * What we do is use preValue - preAdded, which is the value before preAdded,
                 * since * takes higher priority, we use preAdded*currentVal, and add this to the preValue - preAdded.
                 * Pass this preAdded*currentVal as preAdded to next recursion.
                 * */
                getResult(result, exp + "*" + currentVal, preValue-preAdded + preAdded*currentVal, preAdded*currentVal, i+1, target, num);
            }
        }
    }

}
