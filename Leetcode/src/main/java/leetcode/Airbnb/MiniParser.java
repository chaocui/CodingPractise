package leetcode.Airbnb;

import leetcode.util.NestedInteger;

import java.util.Stack;

/**
 * Created by cc on 2017/6/24.
 */
public class MiniParser {

    /**
     * First of all, the returned NestedInteger is always a list of NestedInteger.
     *
     * Key idea here is every open [, indicates one level down, once we go one level deep, we push the previous level to stack.
     * so that when we hit ], means current level is done, and add current level to the previous level(one level up)
     *
     * The way to nest them together,
     * every time we hit [, we push current NestInteger to stack, and create a new NestInteger.
     * every time we hit ], we pop out stack top(if there is any), and current NestInteger to the poped item,
     * sign poped item to current.
     * if we hit ',', if the previous is ], which we already processed, we just set start, and continue;
     * if previous is not ], means this is a number, we need to add this number to current.
     * */
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0) return null;
        //input is not a list
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        NestedInteger current = null;
        int start = 0;
        Stack<NestedInteger> stack = new Stack<>();
        for(int end = 0; end < s.length(); end ++){
            char c = s.charAt(end);
            //if only one level, we dont need push to stack, which is current = null, then we just initialize current.
            //every time we hit [, means this is a new level,
            //we push previous level to stack(if not null)
            //and create new current Level
            if(c == '['){
                if(current != null)
                    stack.push(current);
                current = new NestedInteger();
                start = end + 1;
            }
            /**
             * Every time we hit ], means current level is done
             * two possibility.
             * 123] or ]],
             * so we get the num,
             * if num.length() != 0
             * we add number to current level, otherwise, we dont do this.
             * then if stack is not empty,
             * means there is upper level. So we add current level to upper level.
             * and we jump to upper level by current = stack.pop();
             *
             * Basically, just use stack to keep track of upper level.
             * */
            else if(c == ']'){
                String num = s.substring(start, end);
                if(num.length() != 0)
                    current.add(new NestedInteger(Integer.parseInt(num)));
                if(!stack.isEmpty()){
                    NestedInteger ni = stack.pop();
                    ni.add(current);
                    current = ni;
                }
                start = end + 1;
            }
            /**
             * if we hit a ,
             * two possibility,
             * 123, ],
             * and ], we have processed before
             * if previous is not ], we add number to current level.
             *
             * for each if statement, we set start to end + 1.
             * */
            else if(c == ','){
                if(s.charAt(end - 1) != ']'){
                    String num = s.substring(start, end);
                    current.add(new NestedInteger(Integer.parseInt(num)));
                }
                start = end + 1;
            }
        }
        return current;
    }
}
