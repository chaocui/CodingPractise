package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class RangeSumQueryImmutable {
    //Store the sum from 0 to i

    int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        int len = nums.length;
        sum = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    //Since its inclusive, we need use j + 1.
    //which include j.
    //sum[i] which not include i.
    //so substraction will include both i and j.
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }

}
