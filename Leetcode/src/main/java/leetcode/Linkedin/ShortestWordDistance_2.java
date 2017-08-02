package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/31.
 */
public class ShortestWordDistance_2 {

    /**
     * Assume that word1, word2 does not equal to each other.
     * */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(s.equals(word1))
                p1 = i;
            if(s.equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1)
                result = Math.min(result, Math.abs(p1-p2));
        }
        return result;
    }
}
