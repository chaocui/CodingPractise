package TwoSigma;

/**
 * Created by cc on 2016/8/14.
 */
public class WildcardMatch {

    /**
     * Pre process empty string with p
     *
     * (1) if i, j are regular characters, depending on i-1, j-1
     * (2) if j is ?, depending on i-1,j-1
     * (3) if j is *,
     *     a. if * is 0 character, depending on i, j-1
     *     b. if * is 1 character, depending on i-1, j-1
     *     c, if * is multiple character, depending on i-1, j
     * */
    public boolean isMatch(String s, String p){

        int matrix[][] = new int[s.length()+1][p.length()+1];
        matrix[0][0] = 1;

        //Match empty string. "" and "******"
        for(int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) == '*'){
                matrix[0][j] = matrix[0][j-1];
            }
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) == '*'){
                    //match 0, 1, multi
                    if(matrix[i][j-1]== 1 || matrix[i-1][j-1] == 1 || matrix[i-1][j] == 1){
                        matrix[i][j] = 1;
                    }
                }
                else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        return matrix[s.length()][p.length()] == 1;
    }

    //Worst case O(m*n), Best case O(m+n)
    //a*bcd
    //Match abcabcbbccbcebcfbca.......bcd; every 3 character is bc{not d}. Only the last 3 is bcd
    //If this is the case, it will be m*n. not m+n.
    //best case is m+n.which is s and p never go back.
    //If back tracing happen too many times, it will be m*n
    public boolean isMatchLinear(String s, String p){
        int pS = 0;
        int pP = 0;
        int currentMatch = 0;
        int lastStarIndex = -1;

        while(pS < s.length()){
            //Most common case, if p is ? or p == s, move both p and s forward
            if(pP < s.length() && (p.charAt(pP) == '?' || p.charAt(pP) == s.charAt(pS))){
                pS++;
                pP++;
            }
            //if p is *. same concept as DP
            //* match 0, 1, 2... multiple.
            //Initial is match 0, so currentMatch position is pS, s start match from pS
            //Remember the lastStarIndex to back trace.
            //Move p forward
            else if(pP < s.length() && p.charAt(pP) == '*'){
                currentMatch = pS;
                lastStarIndex = pP;
                pP++;
            }
            //If p != s or p reach the end but s does not.
            //Means that * needs match one more character and re-match s and p.
            //So pP = lastStarIndex + 1;
            //currentMatch ++; * match one more in s.
            //pS = currentMatch;
            //re-match s and p start at pS and pP.
            else if(lastStarIndex != -1){
                currentMatch ++;
                pP = lastStarIndex + 1;
                pS = currentMatch;
            }
            //if p != s && p != ? && p != * && there is no star in p
            //s and p does not match. return false;
            else{
                return false;
            }
        }
        //once s is all checked and is not returning false
        //Check if the rest of P are *s, if not, return false;
        //if yes, return true;
        while(pP < p.length()){
            if(p.charAt(pP) == '*'){
                pP++;
            }
            else{
                break;
            }
        }
        return pP == p.length() - 1;
    }

    public static void main(String[] args){
        WildcardMatch wm = new WildcardMatch();
        System.out.println(wm.isMatch("", "******"));
    }
}
