package leetcode.medium;

import java.util.List;

/**
 * Created by cc on 2017/1/26.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] result = new int[level];
        //DP, Starting from bottom.
        for(int i = 0; i < level; i++){
            result[i] = triangle.get(level-1).get(i);
        }
        for(int i = level-2; i >= 0; i--){
            List<Integer> eachLevel = triangle.get(i);
            for(int j = 0; j < eachLevel.size(); j++){
                result[j] = Math.min(result[j], result[j+1]) + eachLevel.get(j);
            }
        }
        return result[0];
    }
}
