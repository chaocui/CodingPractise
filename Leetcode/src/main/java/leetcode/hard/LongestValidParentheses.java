package leetcode.hard;

import java.util.Stack;

/**
 * Created by cc on 2017/4/12.
 */
public class LongestValidParentheses {

    /**
     * Leetcode first discussion.
     * Very smart solution.
     *
     *
     * Use a stack to keep track of parentheses.
     * If current character is (, push the index to stack.
     * If current character is ), and stack top is (, pop out,
     * otherwise, push index of ) to stack.
     *
     * Once done,
     * if stack is empty, means all parentheses are valid. just return the length of s.
     * is not empty, what in stack is the ones that cannot be paired.
     * So process stack, calculate each two indexes interval, get the longest one.
     *
     * One thing need to be aware is that:
     * when we calculate, we initialized the previous index as s.length(), and assign the current stack top to previous
     * for each iteration.
     *
     * if the last element in stack is not 0, we need to use it - 0 to calculate the length between this index and 0.
     * */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')'){
                if(stack.isEmpty() || s.charAt(stack.peek()) != '(')
                    stack.push(i);
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return s.length();
        int result = Integer.MIN_VALUE;
        int init = s.length();
        while(!stack.isEmpty()){
            int top = stack.pop();
            int diff = init - top - 1;
            result = Math.max(result, diff);
            init = top;
        }
        if(init != 0)
            result = Math.max(result, init - 0);
        return result;
    }

}
