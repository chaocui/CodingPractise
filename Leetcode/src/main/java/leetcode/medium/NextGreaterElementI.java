package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cc on 2017/4/1.
 */
public class NextGreaterElementI {
    /**
     * Since there are duplicates, we can use a hashmap to track the result of each element.
     *
     * Use a stack to keep track decreasing sequence of num.
     * Since findNum is subset of num,

     * then we loop through findNum, see if there is result in hash map,
     * if not, the result is -1, if yes, thats the result.
     * */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {

        Map<Integer, Integer> track = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int num : nums){
            while(!stack.isEmpty() && stack.peek() < num){
                track.put(stack.pop(), num);
            }
            //if decreasing
            stack.push(num);
        }
        int[] result = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++){
            result[i] = track.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}
