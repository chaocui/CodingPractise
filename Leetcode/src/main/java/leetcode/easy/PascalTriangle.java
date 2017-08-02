package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/4/23.
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int row = 1;
        while(row <= numRows){
            List<Integer> eachResult = new ArrayList<>();
            for(int i = 0; i < row; i++){
                if(i == 0 || i == row - 1)
                    eachResult.add(1);
                else{
                    List<Integer> preRow = result.get(row - 2);
                    eachResult.add(preRow.get(i)+preRow.get(i-1));
                }
            }
            result.add(eachResult);
            row ++;
        }
        return result;
    }

}
