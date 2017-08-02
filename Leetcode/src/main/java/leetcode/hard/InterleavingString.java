package leetcode.hard;

/**
 * Created by cc on 2016/11/5.
 */
public class InterleavingString {

    //dp[i][j]
    //Means s1 end at i, s2 end at j, s3 end at i+j is interleaving of s1 and s2.
    public boolean isInterleave(String s1, String s2, String s3) {

        int s1L = s1.length();
        int s2L = s2.length();
        int s3L = s3.length();
        if(s1L+s2L != s3L){
            return false;
        }

        boolean dp[][] = new boolean[s1L+1][s2L+1];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            char c = s1.charAt(i-1);
            char c1 = s3.charAt(i-1);
            if(c==c1){
                dp[i][0] = true;
            }
            else{
                break;
            }
        }

        for(int j = 1; j <= s2.length(); j++){
            char c = s2.charAt(j-1);
            char c1 = s3.charAt(j-1);
            if(c==c1){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }

        for(int i = 1; i <= s1.length(); i++){
            char cS1 = s1.charAt(i-1);
            for(int j = 1; j <= s2.length(); j++){
                char cS2 = s2.charAt(j-1);
                char cS3 = s3.charAt(i+j-1);
                boolean temp1 = false;
                boolean temp2 = false;
                if(cS1 == cS3){
                    temp1 = dp[i-1][j];
                }
                //this one need to or dp[i][j]
                //because dp[i][j] was calculated before, it is true, then cannot change it back to false.
                if(cS2 == cS3){
                    temp2 = dp[i][j-1];
                }
                dp[i][j] = temp1 || temp2;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave1(String s1, String s2, String s3){
        int l1 = s1.length(), l2 = s2.length();

        if(l1+l2 != s3.length()){
            return false;
        }

        boolean dp[][] = new boolean[l1+1][l2+1];
        dp[0][0] = true;

        for(int i = 1; i <= l1; i++){
            char s1c = s1.charAt(i-1);
            char s3c = s3.charAt(i-1);
            if(s1c == s3c){
                dp[i][0] = true;
            }
            else{
                break;
            }
        }

        for(int j = 1; j <= l2; j++){
            char s2c = s2.charAt(j-1);
            char s3c = s3.charAt(j-1);
            if(s2c == s3c){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }

        for(int i = 1; i <= l1; i++){
            for(int j = 1; j<=l2; j++){
                char s1c = s1.charAt(i-1);
                char s2c = s2.charAt(j-1);
                char s3c = s3.charAt(i+j-1);
                boolean temp1 = false, temp2 = false;
                if(s1c == s3c){
                    temp1 = dp[i-1][j];
                }
                if(s2c == s3c){
                    temp2 = dp[i][j-1];
                }
                dp[i][j] = temp1||temp2;
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args){
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("a","","a"));
    }

}
