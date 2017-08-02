package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class ReverseWordsInString {

    /**
     *  Reverse whole string,
     *  reverse each word.
     *
     */
    public String reverseWords(String s) {
        char[] word = s.trim().toCharArray();
        reverse(word, 0, word.length-1);
        StringBuilder result = new StringBuilder();
        int start = 0;
        for(int i = 0; i < word.length; i++){
            if(word[i] == ' '){
                if(word[i-1] != ' ')
                    result.append(reverse(word, start, i - 1)).append(" ");
                start = i+1;
            }
        }
        result.append(reverse(word, start, word.length - 1)).append(" ");
        return result.toString();
    }

    //&& has higher priority than ||
    private String reverse(char[] word, int start, int end){
        int s = start, e = end;
        while(start < end){
            char c = word[start];
            word[start] = word[end];
            word[end] = c;
            start++;
            end--;
        }
        return String.copyValueOf(word, s, e - s + 1);
    }

    public static void main(String[] args) {

    }
}
