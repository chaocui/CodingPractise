package leetcode.medium;

/**
 * Created by cc on 2017/3/12.
 */
public class RemoveDuplicatesfromSortedArrayII {
    //Basic idea,
    //Since at most two duplicate are allowed.
    //We can just check current number with the number at index current - 2
    //if current is greater than that, means current at most showed up once current(might be current -1)
    //so we put this number at position current.


    //If not, means that this showed up at least 3 times. from current - 2 to current.
    //We just move to next n and check.
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for(int n : nums){
            if(result < 2 || n > nums[result - 2]){
                nums[result] = n;
                result++;
            }
        }
        return result;
    }
}
