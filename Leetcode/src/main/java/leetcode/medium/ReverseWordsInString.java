package leetcode.medium;

/**
 * Created by cc on 2016/7/12.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        String temp = reverseString(s).trim();
        int start = 0;
        int end = 0;
        for(int i = 0; i < temp.length() ; i++){
            if(temp.charAt(i) == ' ' || temp.charAt(i) == ' '){
                if(end > start){
                    String subString = temp.substring(start, end);
                    String reversedSub = reverseString(subString);
                    result.append(reversedSub).append(" ");
                    start = i + 1;
                    end = i + 1;
                }else{
                    start++;
                    end++;
                }
            }else{
                end ++;
            }
        }
        String subString = temp.substring(start, temp.length());
        String reversedSub = reverseString(subString);
        result.append(reversedSub);
        return result.toString();
    }

    private String reverseString(String s){
        StringBuilder result = new StringBuilder();
        for(int i = s.length() - 1; i>=0; i--){
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        ReverseWordsInString rwis = new ReverseWordsInString();
        System.out.println(rwis.reverseWords("the sky is blue   "));
    }
}
