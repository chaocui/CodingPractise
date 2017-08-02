package leetcode.medium;

import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/3/22.
 */
public class FlattenNestedListIterator {


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

    Stack<NestedInteger> stack = new Stack<>();
     /**
      * Basic idea
      * Use a stack.
      * push every element to stack from right to left.
      * .
      * Since the way they use it is call has next first.
      * every time call has next, if stack peek is Integer, just return true.
      * if stack peek() is list, we pop out, put all elements in list to stack and return true;
      * otherwise return false.
      *
      * Every time call next. we pop out
      * Because the previous process make sure stack top is Integer for sure.
      * if its not it will get popped out and processed.
      * */
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i>=0; i--)
            stack.push(nestedList.get(i));
    }

    public Integer next() {
        return stack.pop().getInteger();
    }

    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()){
                return true;
            }
            NestedInteger ni = stack.pop();
            for(int i = ni.getList().size() - 1; i >= 0; i--){
                stack.push(ni.getList().get(i));
            }
        }
        return false;
    }

}
