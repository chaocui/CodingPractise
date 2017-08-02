package leetcode.Airbnb;

/**
 * Created by cc on 2016/7/31.
 */
public class RegularExpressionMatch {

    /*
    * match[i][j] indicates string s from 0 to i matches string p from 0 to j.
    * */

    /**
     * Regular expression &　wild card matching all have a pre process of empty string
     * consider empty string match result with regular expression.
     * */
    public boolean isMatch(String s, String p) {

        boolean match[][] = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;

        //Pre-process i = 0
        for(int j = 1; j < p.length()+1; j++){
            if(p.charAt(j-1) == '*'){
                if(match[0][j-1] || match[0][j-2]){
                    match[0][j] = true;
                }
            }
        }
        for(int i = 1; i < s.length()+1; i++){
            for(int j = 1; j < p.length()+1; j++){
                if(p.charAt(j-1) == '*'){
                    //match 0 character or 1 character
                    if(match[i][j-2] || match[i][j-1]){
                        match[i][j] = true;
                    }
                    else if(match[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')){
                        match[i][j] = true;
                    }
                }
                else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    match[i][j] = match[i-1][j-1];
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public static void main(String[] args){
        RegularExpressionMatch rem = new RegularExpressionMatch();
        rem.isMatch("aab","c*a*b");
    }

}
