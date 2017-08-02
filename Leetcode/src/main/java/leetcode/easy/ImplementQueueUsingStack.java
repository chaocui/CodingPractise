package leetcode.easy;

import java.util.Stack;

/**
 * Created by cc on 2016/4/12.
 */
public class ImplementQueueUsingStack {

    private Stack<Integer> mainStack = new Stack();
    private Stack<Integer> secStack = new Stack();
    Integer peek = null;

    public void push(int x) {
        if(mainStack.empty())
            peek = x;
        mainStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(mainStack.empty())
            return;
        else{
            while(!mainStack.empty()){
                secStack.push(mainStack.peek());
                mainStack.pop();
            }

            secStack.pop();

            if(secStack.empty())
                peek = null;
            else
                peek = secStack.peek();

            while(!secStack.empty()){
                mainStack.push(secStack.peek());
                secStack.pop();
            }
        }
    }

    // Get the front element.
    public Integer peek() {
        if(mainStack.empty())
            return null;
        else
            return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mainStack.empty();
    }

}
