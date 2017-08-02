package leetcode.easy;

/**
 * Created by cc on 2016/4/9.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }

}
