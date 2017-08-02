package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/22.
 */
public class GrayCode {

    /**
     * Basic idea.
     * initial 0,1
     * every time increase i(initialized as 1) while i < n.
     * what we do is reverse existing result, add 2^i to each of the element, add them to result.
     * repeating this until i = n. so while(i<n);
     * */
    public List<Integer> grayCode(int n) {
        int size = (int)Math.pow(2,n);
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if(n == 0) return result;
        result.add(1);
        if(n == 1) return result;
        int i = 1;
        while(i  < n){
            int addFactor = (int)Math.pow(2,i);
            int len = result.size();
            for(int j = len -1; j>=0; j--){
                result.add(result.get(j) + addFactor);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        List<Integer> result = new ArrayList<Integer>();
        result = gc.grayCode(3);
        for(Integer i : result) System.out.print(i + ",");
    }

}
