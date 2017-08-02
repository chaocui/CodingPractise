package leetcode.Facebook;

/**
 * Created by cc on 2017/6/3.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int zeroStart = 0;
        //if not 0, move zero start.
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                //only swap if current position is not the same as zero start position
                //handle the case that array not starting with 0s
                //e.g. 1,2,3,0,4,0,5
                //for first 3 numbers, we dont swap. when we reach 4, zero start position is at index 3. current is index 4.
                if(i != zeroStart){
                    nums[zeroStart] = nums[i];
                    nums[i] = 0;
                }
                zeroStart ++;
            }
        }
    }
}
