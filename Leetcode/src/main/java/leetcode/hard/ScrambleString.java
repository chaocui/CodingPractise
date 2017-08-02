package leetcode.hard;

/**
 * Created by cc on 2016/11/7.
 */
public class ScrambleString {
    //Recursive solution
    //Cut as soon as possible
    public boolean isScramble(String s1, String s2) {

        if(s1 == null && s2 == null){
            return false;
        }

        int s1L = s1.length();
        int s2L = s2.length();

        if(s1L != s2L){
            return false;
        }

        if(s1L == 1){
            return s1.charAt(0) == s2.charAt(0);
        }

        int dictS1[] = new int[26];
        for(int i = 0; i < s1.length(); i++){
            dictS1[s1.charAt(i)-'a'] ++;
        }

        for(int i = 0; i < s2.length(); i++){
            dictS1[s2.charAt(i)-'a'] --;
        }

        //Loop through list, see any char does not match. then return false.
        for(int i = 0; i < 26; i++){
            if(dictS1[i] != 0){
                return false;
            }
        }

        for(int i = 1; i < s1.length(); i++){

            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
                return true;
            }

            if(isScramble(s1.substring(0,i),s2.substring(s2L-i)) && isScramble(s1.substring(i),s2.substring(0,s2L-i))){
                return true;
            }
        }
        return false;
    }

    //三维 DP， dp[n][i][j], means length n , s1 start from i, s2 start from j, if s1 & s2 are scramble.

    public static void main(String[] args){
        ScrambleString ss = new ScrambleString();
        System.out.println(ss.isScramble("a","a"));
    }
}
