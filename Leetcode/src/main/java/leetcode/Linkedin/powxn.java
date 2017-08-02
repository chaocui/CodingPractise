package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/11.
 */
public class powxn {

    //This question is testing all different cases.
    //mainly n is less than 0, and n is Min integer. need to handle overflow
    public double myPow(double x, int n){
        if(n == 0) return 1;
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                n++;
                //now n is Integer.MAX_VALUE, which is odd
                n = -n;
                x = 1/x;
                return myPow(x*x, n/2)*x*x;
            }
            n = -n;
            x = 1/x;
        }
        return n%2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }

}
