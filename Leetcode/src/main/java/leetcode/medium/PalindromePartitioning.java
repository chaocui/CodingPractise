package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/7/25.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        if(s.length() == 0){
            ArrayList<String> r = new ArrayList<>();
            ArrayList<List<String>> v = new ArrayList<List<String>>();
            v.add(r);
            return v;
        }

        List<List<String>> result = new ArrayList<List<String>>();

        for(int i = 1; i <=  s.length() ; i++){
            String temp = s.substring(0, i);
            if(isPolindrome(temp)){
                List<List<String>> tempResult = partition(s.substring(i, s.length()));
                for(int j = 0; j < tempResult.size(); j++){
                    List<String> each = tempResult.get(j);
                    each.add(0, temp);
                    result.add(each);
                }
            }
        }
        return result;
    }

    private boolean isPolindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    //DP
    //Track any point to end palindrome result.
    //DP map has one more than s.length, the initial point is dp[s.length] List<List<String>> length 1, but empty.
    //Starting at the end of string i, i >= 0, i --
    // Inner loop j starting at i , end at j <= s.length(), j++
    // for(int i = s.length() - 1; i >=0 ; i--){
    //      for(int j = i + 1; j <= s.length; j ++){
    //          if(substring(i, j) is palindrome){
    //              dp[j] is previous result.
    //              pre-pend substring(i,j) to each dp[j]
    //              add all dp[j] to dp[i]
    //          }
    //
    //      }
    // }
    public List<List<String>> partitionDP(String s) {

        List<List<String>> dpMap[] = (List<List<String>>[])Array.newInstance(List.class , s.length()+1);
        ArrayList<String> last = new ArrayList();
        ArrayList<List<String>> lastResult = new ArrayList<List<String>>();
        lastResult.add(last);
        dpMap[s.length()] =  lastResult;

        //Outer most loop, loop through the string, starting at end
        for(int i = s.length() - 1; i >= 0; i--){
            ArrayList<List<String>> currentResult = new ArrayList<List<String>>();
            //inner loop, loop through from current i + 1 to end.
            //Take substring from i to j(exclusive),
            //if substring is palindrome, then prepend substring to all result in dp[j], which is calculated before
            for(int j = i + 1; j <= s.length(); j ++){
                String testString = s.substring(i, j);
                if(isPolindrome(testString)){
                    List<List<String>> preResult = dpMap[j];
                    //if it is polindrome, pre-pend to dp[j], add dp[j] to current result to construct dp[i]
                    for(int m = 0; m < preResult.size(); m++){
                        //dont want to modify previous dp[j], make a clone.
                        List<String> each = new ArrayList<String>(preResult.get(m));
                        each.add(0, testString);
                        currentResult.add(each);
                    }
                }
            }
            dpMap[i] = currentResult;
        }
        return dpMap[0];
    }

    public static void main(String[] args){
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> result = pp.partitionDP("aacbbc");
        System.out.println();
    }

}
