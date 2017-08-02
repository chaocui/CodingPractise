package leetcode.medium;

import com.sun.org.apache.xpath.internal.operations.Div;

/**
 * Created by cc on 2016/7/12.
 */
public class DivideTowInteger {

    //general idea, too large, time out
    public int divide(int up, int down) {

        long dividend = Long.valueOf(up);
        long divisor = Long.valueOf(down);
        boolean negtive = false;
        if(dividend < 0 && divisor < 0){
            dividend = 0 - dividend;
            divisor = 0 - divisor;
        }else if(dividend < 0){
            negtive = true;
            dividend = 0 - dividend;
        }else if(divisor < 0){
            negtive = true;
            divisor = 0 - divisor;
        }
        int result = 0;
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }

        while(dividend >= divisor){
            dividend = dividend - divisor;
            result ++;
        }
        if(negtive)
            result = 0 - result;
        return result;
    }

    //any number can be written as num = a0*2^0 + a1*2^1 + .... + an.
    //an is 0 or 1.
    public int divideFast(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negtive = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift ++;
            }

            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }

        return negtive ? result : -result;
    }

    public static void main(String[] args){

        DivideTowInteger dti = new DivideTowInteger();
        System.out.println(dti.divideFast(1,1));

    }

}
