package leetcode.medium;

/**
 * Created by cc on 2017/3/12.
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums){
            if (i < 1 || n > nums[i-1]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
