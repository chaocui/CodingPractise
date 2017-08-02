package leetcode.Linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/6/24.
 */
public class ShortestWordDistanceII {

    Map<String, List<Integer>> indexs = new HashMap<>();
    public ShortestWordDistanceII(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(!indexs.containsKey(words[i]))
                indexs.put(words[i],new ArrayList<Integer>());
            indexs.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = indexs.get(word1);
        List<Integer> l2 = indexs.get(word2);
        int min = Integer.MAX_VALUE;
        /**
         * Index should be in order
         * so dont need two loops,
         * just one is enough.
         * which one is smaller, just increase the index, so there is a chance to reduce the distance.
         * */
        for(int i = 0, j = 0; i < l1.size() && j < l2.size(); ){
            int p1 = l1.get(i);
            int p2 = l2.get(j);
            if(p1 < p2){
                min = Math.min(p2-p1,min);
                i++;
            }
            else{
                min = Math.min(p1-p2, min);
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] test = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII swd  = new ShortestWordDistanceII(test);
        System.out.println(swd.shortest("practice", "coding"));
    }

}
