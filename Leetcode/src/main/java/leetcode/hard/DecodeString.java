package leetcode.hard;

import java.util.Stack;

/**
 * Created by cc on 2017/3/25.
 */
public class DecodeString {

    /**
     * Use stack:
     * if it is number, push to stack
     * if it is '[' go to next
     * if it is character, push to result.
     * if it is ']', pop out stack top if stack is not empty, repeat this number of times.
     * */
    public class StringWrapper{
        public StringBuilder sb = new StringBuilder();
        public int repeat = 0;
        public StringWrapper(int repeat){
            this.repeat = repeat;
        }
    }

    public String decodeString(String s) {
        Stack<StringWrapper> stack = new Stack<StringWrapper>();
        int num = 0;
        //put a StringWrapper with repeat 1 to stack to initialize stack.
        //means that we will always repeat the result once. which is the result.
        stack.push(new StringWrapper(1));
        for(char c : s.toCharArray()){
            //might be number that greater than 9
            if(c >= '0' && c <= '9'){
                num = num*10 + c - '0';
            }
            //if it is starting parentheses, push number to stack
            else if(c == '['){
                stack.push(new StringWrapper(num));
                num = 0;
            }
            //if it is ending parentheses.
            //We need to get current result and repeat "repeat" times.
            //pop out stack top since current encoded part has been decoded.
            //then append this result to current peek.
            //Since we always have a StringWrapper with repeat 1. Which means repeat the result once.
            else if(c == ']'){
                String currentS = stack.peek().sb.toString();
                int repeat = stack.pop().repeat;
                for(int i = 0; i < repeat; i++){
                    stack.peek().sb.append(currentS);
                }
            }
            //Otherwise, the current character is part of repeating sequence.
            //we update the current stack peek string builder.
            else{
                stack.peek().sb.append(c);
            }
        }
        return stack.pop().sb.toString();
    }

    public static void main(String[] args) {
        String test = "3[a2[b]]2[a]";
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(test));
    }
}
