package leetcode.Linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/6/24.
 */
public class ShortestWordDistance {

    /**
     * 看了一上午， 发现是自己眼瞎了！ 例子看错了！
     * simple idea,
     * just loop through array, find word1 or word2,
     * keep calculating the distance and update the min.
     * */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2))
                p2 = i;
            /**
             * if p1 and p2 are get updated, we calculate the distance.
             * */
            if(p1 != -1 && p2 != -1){
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] test = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistance swd  = new ShortestWordDistance();
        System.out.println(swd.shortestDistance(test, "makes", "coding"));
    }

}
