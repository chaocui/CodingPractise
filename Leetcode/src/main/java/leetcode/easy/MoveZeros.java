package leetcode.easy;

/**
 * Created by cc on 2016/4/3.
 */
public class MoveZeros {
    public void moveZeros(int[] nums){
        int zeroStartsPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(zeroStartsPos != i) {
                    nums[zeroStartsPos] = nums[i];
                    nums[i] = 0;
                }
                zeroStartsPos ++;
            }
        }
    }
}
