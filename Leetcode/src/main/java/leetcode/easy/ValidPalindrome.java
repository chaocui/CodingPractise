package leetcode.easy;

/**
 * Created by cc on 2017/4/19.
 */
public class ValidPalindrome {

    //add continue to make sure we are not using unexpected indexes.
    //for example, if we check not alphanumeric first,
    //we increase i or decrease j. then i j are moved, we check them is not current i, j
    //not precise.
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i = 0, j = s.length() - 1; i < j;){
            if(isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j))){
                if(s.charAt(i) == s.charAt(j)){
                    i++; j--;
                    continue;
                }
                else
                    return false;
            }
            if(!isAlphanumeric(s.charAt(i)))
                i++;
            if(!isAlphanumeric(s.charAt(j)))
                j--;
        }
        return true;
    }

    public boolean isAlphanumeric(char c){
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9');
    }

}
