package leetcode.medium;

import java.math.BigInteger;

/**
 * Created by cc on 2017/2/13.
 */
public class AdditiveNumber {

    //basic idea is
    //determine the first two numbers, so that the following number will be get from first two number.
    //So loop can just based on length of first two number.

    //The key point is we only need to determine the first two elements.
    //关键点是 以 第一 第二 个数的长度来循环递归。
    //因为第一 第二个数 确定以后， 后面的数 都是循环递加得来。
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        for(int i = 1; i <= length/2; i++){
            //0xx is not valid.
            if(num.charAt(0) == '0' && i > 1) return false;
            BigInteger b1 = new BigInteger(num.substring(0,i));
            //Basically, the length of sum of i and j needs to greater or equal to max(i,j)
            //Second number starts at index i.
            for(int j = 1; Math.max(i,j) <= length - i - j; j++){
                if(num.charAt(i) == '0' && j > 1) break;
                BigInteger b2 = new BigInteger(num.substring(i,i+j));
                //Check first two number with length i and j, can form additive number.
                //if yes, return , if not, go to next loop.
                if(isValid(b1, b2, num, i+j)) return true;
            }
        }
        return false;
    }

    //check if num start with b1+b2 at index and the rest isValid.
    //Base condition is once index reach num.lenght.
    //递归 跳出条件是 到达string结尾。
    //tail recursion，剩余部分以和开始， 并且剩余部分依然满足递归。 相应改变第一个数 为之前第二个数，第二个数为和，开始坐标为 之前坐标+和的长度。
    private boolean isValid(BigInteger b1, BigInteger b2, String num, int index){
        if(index == num.length()) return true;
        BigInteger sum = b1.add(b2);
        return num.startsWith(sum.toString(), index) && isValid(b2, sum, num, index+sum.toString().length());
    }

}
