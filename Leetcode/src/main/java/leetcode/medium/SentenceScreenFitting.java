package leetcode.medium;

/**
 * Created by cc on 2017/5/18.
 */
public class SentenceScreenFitting {

    public int wordsTyping1(String[] sentence, int rows, int cols) {
        int wordIndex = 0, size = sentence.length, r = 0;
        int result = 0;
        while(r < rows){
            int c = cols;
            while(c >= sentence[wordIndex%size].length()){
                if(wordIndex%size == size - 1)
                    result++;
                //count the space also.
                c = c - sentence[wordIndex%size].length() - 1;
                wordIndex++;
            }
            r++;
        }
        return result;
    }

    /**
     * Explain
     * https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution/2
     * basically, convert the sentence to string.
     *
     * for example Say sentence=["abc", "de", "f], rows=4, and cols=6.
     * String is abc de f abc de f abc de f ...
     *
     * column is 6.
     * check the 7th character,
     * if it is " ", means previous words just fit in the line, so next starting point is 6+1 which is 7.
     * if it is not " ", we check the previous character until the " ",
     * since we cannot break word, we need to substract start.
     * next line we start at the start after substraction.
     *
     * until we did all the rows.
     * We find the start/s.length() which is the result.
     *
     * */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int start = 0;
        String s = String.join(" ", sentence) + " ";
        int l = s.length();
        for(int i = 0; i < rows; i++){
            start += cols;
            if(s.charAt(start%l) == ' ')
                start++;
            else{
                while(start > 0 && s.charAt((start-1)%l) != ' ')
                    start --;
            }
        }
        return start/s.length();
    }


    public static void main(String[] args) {
        SentenceScreenFitting ssf = new SentenceScreenFitting();
        String[] test = {"I","had","apple","pie"};
        System.out.println(ssf.wordsTyping(test, 4, 5));
    }

}
