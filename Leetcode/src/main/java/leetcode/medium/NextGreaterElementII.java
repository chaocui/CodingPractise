package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cc on 2017/4/1.
 */
public class NextGreaterElementII {
    /**
     * Same idea as NextGreaterElementI
     * use stack to track decreasing,
     * since this one will have dups, we put index in stack.
     * */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        int[] result = new int[len];
        //initialized as all -1.
        Arrays.fill(result, -1);
        for(int i = 0; i < len*2; i++){
            int num = nums[i%len];
            //Not decreasing any more,
            //pop out until stack.peek() >= num
            //at the same time, set result.

            /**
             * Trick part is combine two loops together.
             * everything is the same as I.
             * Different part is II is a circle.
             * So we loop twice for the last element find its result.
             * 1. every index will be push into stack.
             * 2. if(i < n) push will make sure point 1, and also make sure the top will be the last element eventually.
             * 3. after first round, top will be last element.
             * 4. then second round, we just compare stack top (last element) with each element in stack.
             * 5. Once we found the greater one, we just set the result.
             * 6. Also, since stack is holding decreasing sequence. now all the elements that greater than stack top is under the top in stack.
             * Basically, the second round is just for the last element.
             * */
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            if(i < len) stack.push(i);
        }
        return result;
    }
}
