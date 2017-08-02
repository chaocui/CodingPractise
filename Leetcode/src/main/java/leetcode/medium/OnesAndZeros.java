package leetcode.medium;

/**
 * Created by cc on 2017/3/18.
 */
public class OnesAndZeros {

    //Basic idea,
    //for each string in the input.
    //count number of 0s and 1s
    //for dp matrix
    //loop through all combinations which are >= 0s and 1s.
    //dp[i][j] = Math.max(dp[i][j], dp[i-0s][j-1s] + 1);
    public int findMaxForm(String[] strs, int m, int n) {
        //might be either without 0 or 1. so we need index 0 and index m, n,
        //so the initial size is (m+1)*(n+1)
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int[] count = new int[2];
            for(char c : s.toCharArray()){
                if(c == '0') count[0]++;
                if(c == '1') count[1]++;
            }

            //For each combination that has enough number of 0s and 1s to form current s
            //we update them.
            for(int i = m; i >= count[0]; i--){
                for(int j = n; j >= count[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }



}
