package leetcode.hard;

/**
 * Created by cc on 2016/11/13.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int j = 0; j <= word2.length(); j++){
            dp[0][j] = j;
        }

        for(int i = 0; i <= word1.length(); i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                //If equal, then it will be same as dp[i-1][j-1]
                if(c1==c2){
                    dp[i][j] = dp[i-1][j-1];
                }
                //if not equals,
                //then it will be three cases:
                //1. change the char at i and j, so it will be dp[i-1][j-1] + 1
                //2. delete the char at i(so should be steps from change i-1 to j), so it will be dp[i-1][j] + 1
                //3. delete the char at j(so should be steps from change i to j-1), so it will be dp[i][j-1] + 1
                else{
                    //change
                    int changeChar = dp[i-1][j-1]+1;
                    //Delete from word1
                    int deleteFromWord1 = dp[i-1][j] + 1;
                    //Delete from word2
                    int deleteFromWord2 = dp[i][j-1] + 1;
                    dp[i][j] = Math.min(changeChar, Math.min(deleteFromWord1, deleteFromWord2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
