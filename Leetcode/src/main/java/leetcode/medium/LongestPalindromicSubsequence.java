package leetcode.medium;

/**
 * Created by cc on 2017/3/28.
 */
public class LongestPalindromicSubsequence {

    //basic idea.
    //dp solution.
    //dp[i][j] holds maximum palindromic subsequence length from i to j.
    //all i == j, will be 1. since it is one character.
    //all i < j, will be the result,
    //all i > j, will be 0. since we only count i < j.
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //i moves to left
        for(int i = s.length() - 1; i >= 0; i --){
            //initialize one character sequence to be 1.
            dp[i][i] = 1;
            //j starting from right side of i, and move to right.
            for(int j = i+1; j < s.length(); j++){
                //if char at i and j are equal, so we can just update dp[i][j] as the maximum without i and j +2
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                //otherwise, we take maximum from i+1 to j or i to j-1
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
