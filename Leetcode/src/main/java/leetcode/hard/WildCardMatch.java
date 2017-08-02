package leetcode.hard;

/**
 * Created by cc on 2016/7/31.
 */
public class WildCardMatch {
    public boolean isMatch(String s, String p) {
        boolean match[][] =  new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;

        //Pre process i = 0
        for(int j = 1; j < p.length() + 1; j++){
            if(p.charAt(j-1) == '*'){
                match[0][j] = match[0][j-1];
            }
        }

        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                if(p.charAt(j-1) == '*'){
                    //Any m before i, match j - 1. then m to i match *
                    for(int m = i; m >=0; m--){
                        if(match[m][j-1]){
                            match[i][j] = true;
                            break;
                        }
                    }
                }
                else if((p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) && match[i-1][j-1]){
                    match[i][j] = true;
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public boolean isMatchWay2(String s, String p) {
        boolean match[][] =  new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;

        //Pre process i = 0
        for(int j = 1; j < p.length() + 1; j++){
            if(p.charAt(j-1) == '*'){
                match[0][j] = match[0][j-1];
            }
        }

        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                if(p.charAt(j-1) == '*'){
                    //match 0 char, match 1 char, match more than 1 char. Any of them is true, it is true.
                    match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-1][j];
                }
                else if((p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) && match[i-1][j-1]){
                    match[i][j] = true;
                }
            }
        }
        return match[s.length()][p.length()];
    }

}
