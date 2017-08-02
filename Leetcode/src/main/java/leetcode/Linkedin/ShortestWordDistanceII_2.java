package leetcode.Linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/7/31.
 */
public class ShortestWordDistanceII_2 {

    Map<String, List<Integer>> dict;
    public ShortestWordDistanceII_2(String[] words) {
        dict = new HashMap();
        for(int i = 0; i < words.length; i++){
            String each = words[i];
            if(!dict.containsKey(each))
                dict.put(each, new ArrayList<Integer>());
            dict.get(each).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = dict.get(word1);
        List<Integer> l2 = dict.get(word2);
        int result = Integer.MAX_VALUE;
        //basically, indexes are in order,
        //move the smaller one, has chance to reduce the distance.
        //once either of the index reach the end.(only smaller one has chance to reach the end)
        //we dont have to move any more, since if we keep moving(which is the larger one, the distance will only increase.)
        for(int i = 0, j = 0; i < l1.size() && j < l2.size();){
            int p1 = l1.get(i);
            int p2 = l2.get(j);
            result = Math.min(Math.abs(p1-p2), result);
            if(p1 < p2)
                i ++;
            else
                j++;
        }
        return result;
    }

}
