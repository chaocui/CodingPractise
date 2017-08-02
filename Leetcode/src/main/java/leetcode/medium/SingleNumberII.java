package leetcode.medium;

/**
 * Created by cc on 2016/7/15.
 */
public class SingleNumberII {
    //Mathematical operators has higher priority than bit shifting.
    //Bit shifting higher than &, |, ^
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] oneCount = new int[32];
        for (int i = 0; i< 32; i++) {
            for(int j = 0; j < nums.length; j++){
                oneCount[i] = oneCount[i] + ((nums[j]>>i)&1);
            }
            result |= ((oneCount[i]%3) << i);
        }
        return result;
    }

    public static void main(String[] args){

        SingleNumberII siii = new SingleNumberII();

        int[] testCase = {2,2,2,1};
        System.out.println(siii.singleNumber(testCase));

    }

}
