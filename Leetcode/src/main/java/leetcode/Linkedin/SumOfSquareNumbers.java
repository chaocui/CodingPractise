package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/13.
 */
public class SumOfSquareNumbers {

    /**
     * Basic idea is
     * find the square root of given number
     * from 0 to the square root,
     * if sum is bigger, move right, if smaller, move left, if equal, return true
     */
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while(left <= right){
            int sum = left * left + right * right;
            if(sum < c)
                left ++;
            else if(sum > c)
                right --;
            else return true;
        }
        return false;
    }



}
