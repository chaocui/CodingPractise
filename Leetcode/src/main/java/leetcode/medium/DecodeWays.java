package leetcode.medium;

/**
 * Created by cc on 2016/7/20.
 */
public class DecodeWays {

    /*
    * DP
    * Cannot start as 0;
    * if s.length = 0 || s.charAt(0) == '0' return 0;
    * start result[length+1]
    * result[0] = 1, result[1] = 1;
    * starting from index 2.
    *
    * Will be easy and clear to only consider the valid cases.
    * See current with previous.
    * if current not 0, result[i] += result[i-1]; 即 前n-1的解码方法 都可以用, 每种方法append current.
    * if current and previous combination is > 9 && <=26. result[i] += result[i-2]; 即 前n-2的解码方法都可以用，每种方法append combination.
    * if result[i] == 0, return 0; which means cannot decode
    * */
    public int numDecodings(String s) {

        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }

        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = 1;

        for(int i = 1; i < s.length(); i++){
            int number = 10*(s.charAt(i-1)-'0')+s.charAt(i) - '0';
            if(number > 9 && number <= 26){
                ways[i+1] += ways[i-1];
            }

            if(s.charAt(i) != '0'){
                ways[i+1] += ways[i];
            }

            if(ways[i+1] == 0){
                return 0;
            }
        }
        return ways[s.length()];
    }

    public static void main(String[] args){
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("01"));
    }
}
