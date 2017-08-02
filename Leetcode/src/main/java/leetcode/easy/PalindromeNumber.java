package leetcode.easy;

/**
 * Created by cc on 2017/4/23.
 */
public class PalindromeNumber {

    /**
     * basic idea is reverse half of x.
     * if there are even number of digits
     * x == rev
     * otherwise
     * x == rev/10
     *
     * special cases is x%10 == 0
     * number cannot starting with 0, so just return false.
     * */
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x%10 == 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return x == rev || x == rev/10;
    }

}
