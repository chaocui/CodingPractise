package leetcode.medium;

/**
 * Created by cc on 2017/1/26.
 */
public class IncreasingTripletSubsequence {

    //Basic idea,
    //have two variables, small, big
    //loop through array, keep updating small, big.
    //if any number is greater than big.
    //return true;
    //otherwise till the end of loop, return false.
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            //Since we update small first, we can guarantee that
            //there is always a small before a big
            if(n <= small) small = n;
            else if(n <= big) big = n;
            //If ever update big, means that there are already two increasing sequence.
            //Once we find one greater than big, means we found 3 increasing sequence.
            else return true;
        }
        return false;
    }
}
