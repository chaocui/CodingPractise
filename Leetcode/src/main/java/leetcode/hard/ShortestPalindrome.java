package leetcode.hard;

/**
 * Created by cc on 2016/11/2.
 */
public class ShortestPalindrome {

    //This is so fucking slow. Use KMP to find the match will be faster.
    public String shortestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        String srv = sb.reverse().toString();

        int commonLength = 0;
        int sIndex = 0;
        for(int i = 0; i < srv.length();i++){
            int j = i;
            for(;j < srv.length(); j++){
                if(srv.charAt(j) == s.charAt(sIndex)){
                    sIndex ++;
                    commonLength ++;
                }
                else{
                    sIndex = 0;
                    commonLength = 0;
                    break;
                }
            }
            if(j == srv.length()){
                break;
            }
        }
        int resultLength = srv.length() - commonLength;
        return srv.substring(0, resultLength) + s;
    }

    public static void main(String[] args){

        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("aacecaaa"));


    }
}
