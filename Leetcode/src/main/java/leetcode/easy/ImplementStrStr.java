package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++){
            int j = 0;
            for(j = 0; j < needle.length(); j++){
                if(i+j == haystack.length()) return -1;
                if(haystack.charAt(i+j) != needle.charAt(j))break;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr iss = new ImplementStrStr();
        System.out.println(iss.strStr("mississippi","issip"));
    }
}
