package leetcode.medium;

/**
 * Created by cc on 2016/8/7.
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        int isPalin[][] = new int[s.length()][s.length()];
        int maxL = 0;
        int start = 0;
        int end = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){

                if((j-i<2 && s.charAt(i) == s.charAt(j)||
                    s.charAt(i)==s.charAt(j) && isPalin[i+1][j-1] == 1)){
                    isPalin[i][j] = 1;
                    int length = j-i+1;
                    if(length > maxL){
                        maxL = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }

    public static void main(String[] args){
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("aaaa"));
    }
}
