package TwoSigma.QuestionSet1;

/**
 * Created by cc on 2016/8/28.
 *
 *
 */
public class WildcardMatching{

    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean match[][] = new boolean[m+1][n+1];
        match[0][0] = true;

        //match emtpy string s
        for(int j = 1; j <=p.length(); j++){
            if(p.charAt(j-1) != '*'){
                break;
            }
            match[0][j] = true;
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    match[i][j] = match[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-1][j];
                }
            }
        }
        return match[m][n];
    }

    public boolean isMatchLinear(String s, String p){

        int pS = 0;
        int pP = 0;
        int sl = s.length();
        int pl = p.length();
        int lastStarIndex = -1;
        int startMatchSIndex = -1;

        //Sort of same idea,
        //* greedy match, 0, 1, 2, until find a match. otherwise return false;
        while(pS < sl){
            char charS = s.charAt(pS);
            //If equal or p is ?, move both
            if(pP < pl && p.charAt(pP) == '?' || charS == p.charAt(pP)){
                pS++;
                pP++;
            }
            //If p is *, mark * to back tracing. start match at p+1; s not change
            else if(pP < pl && p.charAt(pP) == '*'){
                lastStarIndex = pP;
                startMatchSIndex = pS;
                pP++;
            }
            //If p is not * and not ?, p, s does not match,
            else if(pP < pl && lastStarIndex != -1){
                pP = lastStarIndex+1;
                startMatchSIndex++;
                pS = startMatchSIndex;
            }
            else{
                return false;
            }
        }

        while(pP < pl){
            if(p.charAt(pP)!='*'){
                return false;
            }
            pP++;
        }
        return true;
    }

    public static void main(String[] args){
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatchLinear("","*******"));
        System.out.println(wm.isMatchLinear("","***p***"));
        System.out.println(wm.isMatchLinear("abcd","a?cd"));
        System.out.println(wm.isMatchLinear("abcd","*d"));
        System.out.println(wm.isMatchLinear("abcd","*?cd"));
        System.out.println(wm.isMatchLinear("abcd","b*cd"));
    }
}
