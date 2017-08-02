package leetcode.easy;

/**
 * Created by cc on 2017/4/21.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(true){
            if(i == strs[0].length()) break;
            char c = strs[0].charAt(i);
            int j = 1;
            for(j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c)
                    break;
            }
            if(j == strs.length)
                result.append(c);
            else
                return result.toString();
            i++;
        }
        return result.toString();
    }
}
