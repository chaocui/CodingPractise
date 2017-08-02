package leetcode.Linkedin;

/**
 * Created by cc on 2017/6/25.
 */
public class ShortestWordDistanceIII {

    /**
     * Same logic as not the same
     * */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        //initialize p1 and p2 as min and -min,
        /**
         * if find any one first, min will still be Integer.MAX_VALUE.
         * because, (-min  - positive), the absolute value is greater than min.
         * */
        long min = Integer.MAX_VALUE, p1 = min, p2 = -min;
        boolean same = word1.equals(word2);
        for(int i = 0; i < words.length; i++){
            //if they are the same get handled in first if, so we use else if .
            if(words[i].equals(word1)){
                if(same){
                    p1 = p2;
                    p2 = i;
                }
                else
                    p1 = i;
            }
            else if(words[i].equals(word2))
                p2 = i;
            min = Math.min(min, Math.abs(p1-p2));
        }
        return (int)min;
    }

    public static void main(String[] args) {
        String[] test = {"a","a","b","b"};
        ShortestWordDistanceIII swd3 = new ShortestWordDistanceIII();
        System.out.println(swd3.shortestWordDistance(test, "b","b"));
    }

}
