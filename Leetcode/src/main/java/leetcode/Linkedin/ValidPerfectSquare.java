package leetcode.Linkedin;

import leetcode.medium.ValidateIPAddress;

/**
 * Created by cc on 2017/6/24.
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long start = 0, end = num;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(mid * mid > num){
                end = mid-1;
            }
            else if(mid * mid < num){
                start = mid+1;
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.println(vps.isPerfectSquare(121));
    }
}
