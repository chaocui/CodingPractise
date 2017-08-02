package leetcode.medium;

import java.util.Stack;

/**
 * Created by cc on 2016/8/7.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                operand.push(operand.pop()+operand.pop());
            }
            else if(tokens[i].equals("-")){
                operand.push(-operand.pop()+operand.pop());
            }
            else if(tokens[i].equals("/")){
                int operand1 = operand.pop();
                int operand2 = operand.pop();
                operand.push(operand2/operand1);
            }
            else if(tokens[i].equals("*")){
                operand.push(operand.pop()*operand.pop());
            }
            else{
                operand.push(Integer.parseInt(tokens[i]));
            }
        }
        return operand.pop();
    }

    private boolean isNumber(String s){
        return (Integer.parseInt(s)+"").equals(s);
    }

    public static void main(String[] args){
        EvaluateReversePolishNotation rpn = new EvaluateReversePolishNotation();
        String test[] = {"0","3","/"};
        System.out.println(rpn.evalRPN(test));
    }

}
