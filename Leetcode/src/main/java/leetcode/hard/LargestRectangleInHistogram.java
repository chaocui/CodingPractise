package leetcode.hard;

import java.util.Stack;

/**
 * Created by cc on 2016/11/13.
 */
public class LargestRectangleInHistogram {

    //Use a stack. store the indexes, not the values
    //If next value > stack top, push to stack
    //if equal, move to next.
    //else pop stack top, calculate area, mark starting position of current height. until find one stack top <= value.
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        Stack<Integer> index = new Stack<>();
        Stack<Integer> h = new Stack<>();
        int i = 0;
        //Loop through array
        for(i = 0; i < heights.length; i++){
            int height = heights[i];
            int currentPosition = i;
            //Check stack top and current height.
            //Pop and calculate area until current height > peek();
            while(!h.isEmpty() && h.peek() > height){
                currentPosition = index.pop();
                int tempArea = (i-currentPosition) * h.pop();
                result = Math.max(tempArea, result);
            }

            //if stack is not empty && current height == peek() height.
            //So starting point no need to change, is the peek() in index, so just continue;
            if(!h.isEmpty() && height == h.peek()){
                continue;
            }

            //Otherwise, 1, stack empty, 2, current height > peek(). So this height might cause maximum area.
            h.push(height);
            index.push(currentPosition);
        }

        while(!h.isEmpty()){
            int tempArea = (i - index.pop())*h.pop();
            result = Math.max(tempArea, result);
        }
        return result;
    }

    public static void main(String[] args){
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
        int test[] = {1};
        System.out.println(lrih.largestRectangleArea(test));
    }
}
