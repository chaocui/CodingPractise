package leetcode.Uber;

import leetcode.medium.FlattenNestedListIterator;

import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/6/12.
 */
public class FlattenNestedList {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    /**
     * Basic idea is use a stack to keep track of all elements in this list
     * Put everything in stack.
     * Base on the requirement,
     * we do while(hasNext()) next();
     * we call hasNext before next() always.
     * So we can just process in hasNext() function.
     *
     * in hasNext()
     * 1. Check if stack is empty or not
     *      if empty, return false.
     *      if not empty
     *      1. check top, if integer, return true, then next() will return the integer.
     *      2. if its list of nested integers, we process this list. add everything into stack.
     *      We do this while loop until the top element is a integer, then we can return true, so that the next() will return a integer.
     *      if top is not integer, we cannot return, we need to keep break down the nested list until we get top integer,
     *      so that next() call can return something.
     * */
    Stack<NestedInteger> stack = new Stack<>();
    public FlattenNestedList(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i>=0; i--)
            stack.push(nestedList.get(i));
    }

    public Integer next(){
        return stack.pop().getInteger();
    }

    public boolean hasNext(){
        while(!stack.isEmpty()){
            if(stack.peek().isInteger())
                return true;
            NestedInteger ni = stack.pop();
            for(int i = ni.getList().size()-1; i>=0; i--){
                stack.push(ni.getList().get(i));
            }
        }
        return false;
    }

}
