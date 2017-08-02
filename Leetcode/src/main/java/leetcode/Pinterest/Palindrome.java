package leetcode.Pinterest;

/**
 * Created by cc on 2017/6/20.
 */
public class Palindrome {

    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
