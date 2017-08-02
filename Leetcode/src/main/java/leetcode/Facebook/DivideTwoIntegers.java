package leetcode.Facebook;

/**
 * Created by cc on 2017/6/3.
 */
public class DivideTwoIntegers {

    /**
     * Any number can be represented as divisor*(1*2^n + ...... 2^0) = dividend
     *
     * O(log(n))
     * */
    public int divide(int dividend, int divisor) {
        int result = 0;
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = false;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) negative = true;

        long a = (long)Math.abs(dividend), b = (long)Math.abs(divisor);
        while(a >= b){
            int i = 0;
            while(a >= (b << i)){
                i++;
            }
            result += 1 << (i - 1);
            a -= (b << (i - 1));
        }
        return negative ? -result : result;
    }
}
