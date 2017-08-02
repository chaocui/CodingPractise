package leetcode.Pinterest;

/**
 * Created by cc on 2017/6/20.
 */
public class LongestPalindromInString {

    public String longestPalindrome(String s){

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //1 character is always palindrome
        String result = "";
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++)
            isPalindrome[i][i] = true;

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j> 2){
                        isPalindrome[j][i] = isPalindrome[j+1][i-1];
                    }
                    else
                        isPalindrome[j][i] = true;
                }
                if(isPalindrome[j][i]){
                    int length = i - j + 1;
                    if(length > max){
                        max = length;
                        start = j;
                        end = i+1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }


}
