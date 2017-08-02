package leetcode.Airbnb;

import java.util.Stack;

/**
 * Created by cc on 2017/6/24.
 */
public class BasicCalculatorII {
    /**
     * Basic idea is keep track of previous sign.
     * once we hit a number,
     * if previous sign is + or -, just add number with the sign to stack
     * if previous sign is * or /, then means that we need to calculate previous number with current number.
     * then push the result to stack. since * and / has higher priority.
     *
     *
     * At the end, we just add everything in stack.
     * */
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        char preSign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i) - '0');
            }
            /**
             * if current character is a sign or it is the last character,
             * we need to process this last num in string.
             * */
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                if(preSign == '-')
                    stack.push(-num);
                if(preSign == '+')
                    stack.push(num);
                if(preSign == '*')
                    stack.push(stack.pop()*num);
                if(preSign == '/')
                    stack.push(stack.pop()/num);
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}
