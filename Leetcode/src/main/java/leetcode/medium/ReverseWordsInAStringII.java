package leetcode.medium;

/**
 * Created by cc on 2017/5/18.
 */
public class ReverseWordsInAStringII {

    //Reverse the whole String
    //Reverse each word in the String.
    public void reverseWords(char[] s) {

        if(s == null || s.length == 0) return;

        int start = 0, end = s.length-1;
        reverse(s,start,end);
        start = 0;
        end = 0;
        while(end < s.length){
            if(s[end] == ' '){
                reverse(s,start,end-1);
                start = end + 1;
                end = start;
            }
            else
                end++;
        }
        reverse(s, start, end-1);
    }

    public void reverse(char[] s, int start, int end){
        while(start < end){
            swap(s,start,end);
            start ++;
            end --;
        }
    }

    public void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

    public static void main(String[] args) {
        String s = "abcde";
        ReverseWordsInAStringII rws = new ReverseWordsInAStringII();
        char[] c = s.toCharArray();
        rws.reverseWords(c);
        System.out.println();

    }

}
