package leetcode.easy;

/**
 * Created by cc on 2016/4/6.
 */
public class NumberOf1Bits {

    public int hammingWeight(int n){
        int result = 0;
        while(n != 0){
            result += n&1;
            n = n >>> 1;
        }
        return result;
    }

}
