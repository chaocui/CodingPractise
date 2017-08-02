package leetcode.easy;

/**
 * Created by cc on 2017/1/30.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        for(int num : nums){
            if(count == 0){
                count ++;
                result = num;
            }
            else if(num == result){
                count ++;
            }
            else{
                count --;
            }
        }
        return result;
    }
}
