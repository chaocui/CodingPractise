package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/4/16.
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        getResult("",0,num,0,target,result,0);
        return result;
    }

    /**
     * Basically, i got the idea, missed some details.
     * 1. Multiply has higher priority than plus and minus.
     * How to deal with this is we store the previous added or minused value.
     * if current is multiply, we minus the value from previous and add current * previous added or substracted value.
     * 2. cannot initialize from calling function. so that i will miss the substrings string from 0 to following indexes.
     * instead, deal with start = 0 case in recursion function.
     * if it is 0, we dont append any operators. dont need to calculate either.
     * 3. Number starting from 0 is invalid, we need to ignore.
     * basically, if i moves after start, and position start is 0, we just break.
     *
     *
     * THIS IS BACK TRACING!!! COOL
     * */
    public void getResult(String preExpression, long preValue, String num, int start, int target, List<String> result, long mult){
        if(start == num.length()){
            if(preValue == target)
                result.add(preExpression);
            else
                return;
        }
        for(int i = start; i < num.length(); i++){
            //means that i move forward, number starting from start end i - 1. if start position is 0, its not a valid number.
            if(i != start && num.charAt(start) == '0') break;
            long currentValue = Long.parseLong(num.substring(start, i+1));
            if(start == 0){
                getResult(currentValue+"",currentValue,num,i+1,target,result,currentValue);
            }
            else{
                String currentExp1 = preExpression + "+" + currentValue;
                getResult(currentExp1,preValue + currentValue,num,i+1,target,result,currentValue);

                String currentExp2 = preExpression + "-" + currentValue;
                getResult(currentExp2,preValue - currentValue,num,i+1,target,result, -currentValue);

                String currentExp3 = preExpression + "*" + currentValue;
                getResult(currentExp3,preValue-mult + mult*currentValue,num,i+1,target,result, mult*currentValue);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators eao = new ExpressionAddOperators();
        //List<String> result = eao.addOperators("123",6);
        List<String> result = eao.addOperators("105",5);
        for(String s : result)
            System.out.println(s);
    }

}
