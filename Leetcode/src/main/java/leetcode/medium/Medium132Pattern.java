package leetcode.medium;

import java.util.Stack;

/**
 * Created by cc on 2016/12/17.
 */
public class Medium132Pattern {

    public class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    //Use pair to track previous min to max intervals, see any following number falls into the interval
    //If current num < peak.min, create new pair push into stack
    //If current num > peak.min && < peak.max, return true;
    //If >= peak.max,
    //Pop out peak, update peak max, if current interval cover peak interval, pop peak out, no need to check smaller interval if we have bigger.
    //Until we not cover, which means peak max > current max or stack is empty.
    //Now check current number sits in current interval, if yes return true;
    //Then push the current interval into stack.

    //For each interval min, it always smaller then the one below itself in the stack.
    //So if it is not bigger then the current min, it cannot be bigger then the one below current.
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<Pair>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(stack.isEmpty()){
                stack.push(new Pair(num,num));
                continue;
            }
            if(num <= stack.peek().min){
                stack.push(new Pair(num, num));
            }
            else if(num < stack.peek().max){
                return true;
            }
            else{
                Pair top = stack.pop();
                top.max = num;
                while(!stack.isEmpty() && stack.peek().max <= num){
                    stack.pop();
                }
                if(!stack.isEmpty() && num > stack.peek().min){
                    return true;
                }
                stack.push(top);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int test[] = {3,5,0,3,4};
        Medium132Pattern mp = new Medium132Pattern();
        System.out.println(mp.find132pattern(test));
    }

}
