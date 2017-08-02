package leetcode.hard;

/**
 * Created by cc on 2016/7/25.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        return partitionDP(s) - 1;
    }
    public int partitionDP(String s) {

        int dpMap[] = new int[s.length()+1];
        boolean[][] matrix = new boolean[s.length()][s.length()];

        for(int i = 0; i <= s.length(); i++){
            dpMap[i] = s.length() - i;
        }

        //Outer most loop, loop through the string, starting at end
        for(int i = s.length() - 1; i >= 0; i--){
            //inner loop, loop through from current i + 1 to end.
            //Take substring from i to j(exclusive),
            //if substring is palindrome, then prepend substring to all result in dp[j], which is calculated before
            for(int j = i; j < s.length(); j ++){
                //This matrix dp corner case is brilliant, awesome!
                if((j - i < 2 && s.charAt(j) == s.charAt(i)
                || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))){
                    matrix[i][j] = true;
                    dpMap[i] = Math.min(dpMap[i], dpMap[j+1] + 1);
                }
            }
        }
        return dpMap[0];
    }

    public static void main(String[] args){
        PalindromePartitioningII pp = new PalindromePartitioningII();
        //List<List<String>> result = pp.partitionDP("aacbbc");
        int result = pp.minCut("aab");
        System.out.println();
    }
}
