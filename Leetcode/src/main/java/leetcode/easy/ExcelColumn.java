package leetcode.easy;

/**
 * Created by cc on 2016/4/4.
 */
public class ExcelColumn {

    public int titleToNumber(String s){

        int result = 0;
        for(int i = 0 , j = s.length() ; i < s.length(); i ++, j--){
            int diff = s.charAt(i) - ('A' - 1);
            result = (int)Math.pow(26, j - 1)*diff + result;
        }

        return result;
    }
}
