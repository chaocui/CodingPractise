package leetcode.easy;

/**
 * Created by cc on 2016/4/4.
 */
public class ValidAnagram {

    public boolean isAnagram(String t, String s){

        if(t.length() != s.length())
            return false;

        //one character is 8 bits, so maximum is 256.
        int[] count = new int[256];
        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)] ++;
        }

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)] --;
            if(count[s.charAt(i)] < 0)
                return false;
        }
        return true;
    }

}
