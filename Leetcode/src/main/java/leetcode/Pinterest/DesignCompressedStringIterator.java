package leetcode.Pinterest;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignCompressedStringIterator {

    /**
     * Keep track of current index and next index of char.
     * When extract the count, save the next char index.
     *
     * when currentCount == 0, sign next char index to char index
     * then extract the count(which will set next char index).
     * */
    int currentCount;
    int charIndex;
    int nextCharIndex;
    String s;
    public DesignCompressedStringIterator(String compressedString) {
        this.s = compressedString;
        currentCount = extractCount(0, compressedString);
        charIndex = 0;
    }

    public char next() {
        if(hasNext()){
            currentCount--;
            return s.charAt(charIndex);
        }
        return ' ';
    }

    public boolean hasNext() {
        if(currentCount > 0)
            return true;
        //there is no more next char, we reach the end of the string, so return false;
        if(charIndex == nextCharIndex)
            return false;
        charIndex = nextCharIndex;
        if(nextCharIndex < s.length()){
            currentCount = extractCount(nextCharIndex, s);
            return true;
        }
        return false;
    }

    private int extractCount(int start, String s){
        int result = 0;
        for(int i = start + 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                result = result*10 + c - '0';
            else {
                nextCharIndex = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String test = "x6";
        DesignCompressedStringIterator dcsi = new DesignCompressedStringIterator(test);
        for(int i = 0; i < 32; i++)
            System.out.println(dcsi.next());
    }

}
