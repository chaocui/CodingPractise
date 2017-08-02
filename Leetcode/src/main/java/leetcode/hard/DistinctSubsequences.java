package leetcode.hard;

/**
 * Created by cc on 2016/9/7.
 */
public class DistinctSubsequences {

    public int distinctSubseq(String s, String t){

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < s.length()+1; i++){
            dp[i][0] = 1;
        }

        //DP maintains from 0 to i of S, number of ways to get 0 to j of T.
        //from 0 to i-1 of S have X number of ways to get 0 to j of T.
        //s.charAt(i) and t.charAt(j) equal or not does not matter.
        //So we have two choices when they are equal, delete s.charAt(i) or not.
        //So if equal, dp[i][j] = dp[i-1][j-1](this means keep i) + dp[i-1][j](this means delete i);
        //if not, dp[i][j] = dp[i-1][j](have to delete i);
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){

                if(s.charAt(i-1) != t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

}
