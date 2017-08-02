package leetcode.medium;

/**
 * Created by cc on 2017/5/21.
 */
public class OneEditDistance {

    /**
     * Basic idea,
     * loop through both s and t, one iterator.
     * boundary is the one has less length.
     * if current char is not the same.
     *      1. if length are the same, then rest string must equlas
     *      2. if s is longer, then s substring i+1 must equals to t sub string i
     *      3. same t is longer.
     *
     * If all previous char are the same, then the length difference must be 1.
     * */
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                //if same length, then rest of the string must be the same.
                if(s.length() == t.length())
                    return s.substring(i+1).equals(t.substring(i+1));
                //delete from s, or add to t
                else if(s.length() > t.length())
                    return s.substring(i+1).equals(t.substring(i));
                else if(s.length() < t.length())
                    return s.substring(i).equals(t.substring(i+1));
            }
        }
        //if all equals, then the difference of length must be one
        return Math.abs(s.length()-t.length()) == 1;
    }

}
