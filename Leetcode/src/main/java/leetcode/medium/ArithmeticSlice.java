package leetcode.medium;

/**
 * Created by cc on 2017/1/8.
 */
public class ArithmeticSlice {

    //Basic idea, DP
    //Any slice is arithmetic,
    // depending on dp[i][j] = dp[i][j-1] && num[j] - num[j-1] == num[j-1] - num[j-2];
    //For every true, count result.
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        int len = A.length;
        boolean dp[][] = new boolean[len][len];
        //initialize dp matrix, length 1 and 2 slices are true;
        //but we don't count them as part of result.
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
            if(i+1<len) dp[i][i+1] = true;
        }

        for(int i = 0; i < len-2; i++){
            for(int j = i+2; j < len; j++){
                if(dp[i][j-1]){
                    dp[i][j] = (A[j-1] - A[j-2]) == (A[j] - A[j-1]);
                    if(dp[i][j]) result++;
                }
            }
        }
        return result;
    }

    //Tricky solution.
    //O(n) time, O(1)space
    //Basically, every 3 consecutive can form arithmetic,
    //Then means that previous (current - 1) can extend to here,
    //So we have (current++)new consecutive.
    //Add current to result.
    //Otherwise, reset current.
    public int numberOfArithmeticSlices1(int[] A) {
        int result = 0;
        int current = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                current ++;
                result += current;
            }
            else{
                current = 0;
            }
        }
        return result;
    }

}
