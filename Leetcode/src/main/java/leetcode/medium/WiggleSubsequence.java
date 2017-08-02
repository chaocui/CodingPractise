package leetcode.medium;

/**
 * Created by cc on 2017/3/14.
 */
public class WiggleSubsequence {

    /**
     * Important part is locate the starting point.
     * if sequence begins with equal numbers. we need to start at the first non equal number or we start at the end. and return 1.
     * then we determine if it is increasing or decreasing.
     * then we loop from start, keep track of previous once we found a increase or decrease, we flip the increasing flag to the opposite.
     * */
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length < 2) return length;
        int pre = nums[0];
        //determine the first two pair is increasing or decreasing.
        int start = 1;
        while(start < length-1 && nums[start] == nums[start-1]) start++;
        boolean increasing = nums[start] > nums[start - 1];
        int result = 1;
        //loop through from index 1;
        for(int i = start; i < length; i++){
            //if its increasing.
            if(increasing){
                if(nums[i] > nums[i-1]){
                    result++;
                    //flip flag to the opposite.
                    increasing = !increasing;
                }
            }
            else{
                if(nums[i] < nums[i-1]){
                    result ++;
                    increasing = !increasing;
                }
            }
            pre = nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = {1,2,1,1,1,1,1,1};
        WiggleSubsequence ws = new WiggleSubsequence();
        System.out.println(ws.wiggleMaxLength(test));
    }
}
