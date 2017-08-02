package leetcode.hard;

import java.util.Random;

/**
 * Created by cc on 2017/4/8.
 */
public class RandomPickIndex {

    Random r;
    int[] nums;
    public RandomPickIndex(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    //basically, loop through the whole array.
    //if not the target we skip.
    //if it is the target. then we decide if we chang the previous result.
    //the probability of chose current one is 1/count.
    //the probability of not chose current one is (count-1)/count.

    //The probability of chose the previous one is 1/(count-1) * (count-1)/count = 1/count.
    //The conclusion can be get by just sampling couple examples.
    public int pick(int target) {
        int count = 0;
        int result = -1;
        for(int i = 0; i < this.nums.length; i++){
            if(this.nums[i] != target)
                continue;
            count++;
            if(r.nextInt(count) == 0)
                result = i;
        }
        return result;
    }
}
