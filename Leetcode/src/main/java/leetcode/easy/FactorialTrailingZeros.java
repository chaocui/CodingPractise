package leetcode.easy;

/**
 * Created by cc on 2017/4/23.
 */
public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int result = 0;
        long factor = 5;
        while(n / factor > 0){
            result += (n/factor);
            factor = factor*5;
        }
        return result;
    }

}
