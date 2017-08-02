package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/31.
 */
public class ShortestWordDistanceIII_2 {

    /**
     * Assume that word1 and word2 can be the same.
     * if they are the same, they represent two different words
     * */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean isSame = word1.equals(word2);
        long p1 = Integer.MIN_VALUE, p2 = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(s.equals(word1)){
                if(isSame){
                    p1 = p2;
                    p2 = i;
                }
                else p1 = i;
            }
            else if(s.equals(word2))
                p2 = i;
            result = Math.min(Math.abs(p1 - p2), result);
        }
        return (int)result;
    }
}
