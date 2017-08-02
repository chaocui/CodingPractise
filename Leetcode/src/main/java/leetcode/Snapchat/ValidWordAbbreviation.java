package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/22.
 */
public class ValidWordAbbreviation {

    /**
     * This way to think is more easier to write the code.
     * 1. Compare i and j see if they are the same.
     *    if yes, move forward
     * 2. if not same, then abbr must have digits.
     *    if it is not digits in abbr or it is a 0, return false. since this is not valid.
     * 3. if it is regular digit,
     *    we start parse the number.
     *    at the same time, j will move to next non-digit place.
     * 4. Once we get the number, set i to i + num.
     * Then loop again. if they are not equal,
     * will return on if char at J <= 0 || char at j > 9
     * */
    public boolean validWordAbbreviation(String word, String abbr){
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            //if they are not equal && abbr not a non-zero digit. return false.
            //otherwise we start to parse the number.
            //we check non-zero because this is the start of the number.
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') return false;
            int start = j;
            //j exclusive
            //if we reach here, start is not 0 which is guaranteed, now we need to check 0.
            while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9')
                j++;
            int num = Integer.parseInt(abbr.substring(start, j));
            i = i + num;
        }
        return i == word.length() && j == abbr.length();
    }
    /**
     * This solution doesnt handle invalid characters.
     * for example:
     * $, #, ^ these characters in string.
     * number starting as 0 like 0123, this solution will evaluate 0123 to 123.
     * */
    public boolean validWordAbbreviation1(String word, String abbr) {
        int start = 0;
        int i = 0, j = 0;
        for(i = 0, j = 0; i < abbr.length() && j < word.length(); i++){
            char c = abbr.charAt(i);
            if(c >= 'a' && c <= 'z'){
                int steps = 0;
                if(start != i)
                    steps = Integer.parseInt(abbr.substring(start, i));

                j = j + steps;
                if(j >= word.length()) return false;
                if(c == word.charAt(j)){
                    j++;
                    start = i + 1;
                }
                else
                    return false;
            }
        }
        int steps = 0;
        if(start != i)
            steps = Integer.parseInt(abbr.substring(start, i));
        j = j + steps;
        return i == abbr.length() && j == word.length();
    }

    public static void main(String[] args) {
        String test = "i12iz5";
        String test1 = "internationalization";
        ValidWordAbbreviation vwa = new ValidWordAbbreviation();
        System.out.println(vwa.validWordAbbreviation(test1, test));
        System.out.println(Integer.parseInt("01"));

    }
}
