package leetcode.medium;

/**
 * Created by cc on 2016/11/17.
 */
public class RemoveKDigits {

    /*
    * Basic idea is
    * Have a result string
    * loop through num, for each num
    * if result string is not empty and k is greater than 0 and current char is less than last char in result.
    * remove last char in result, minus 1 from k(because we abandond one already, so need to do k - 1 times more)
    * After this inner loop, append current char to result.
    *
    * Since in previous processing, we ignore equal case, so the result now might have more than expected, which is n - k.
    * So we only take n - k from current result.
    *
    * Then we need to ignore 0s at the beginning.
    *
    * Then if result is empty, we return 0, otherwise, return result.
    *
    * */
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder();
        int resultLength = num.length() - k;

        //Loop through each char in num
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            //if result is not empty && there is more need to be delete && current char is less than last char in result
            //substract 1 from k, delete last char from result
            while(result.length() != 0 && k > 0 && c < result.charAt(result.length()-1)){
                k--;
                result.deleteCharAt(result.length() - 1);
            }
            //after loop, we append current char
            result.append(c);
        }
        //we take only needed length
        result.setLength(resultLength);
        //we delete preceding 0s.
        //need to check length first, in order to avoid out of boundary exception.
        //if not length 0, and first char is 0, delete first one and keep checking.
        while(result.length() != 0 && result.charAt(0) ==  '0'){
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

}
