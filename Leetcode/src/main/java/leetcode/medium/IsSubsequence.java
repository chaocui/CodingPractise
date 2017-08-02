package leetcode.medium;

/**
 * Created by cc on 2017/3/29.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //empty string is subsequence of any string.
        if(s.length() == 0) return false;
        int sIndex = 0;
        int tIndex = 0;
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(sIndex) == t.charAt(i))
                sIndex ++;
            if(sIndex == s.length())
                return true;
        }
        return false;
    }
}
