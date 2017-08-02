package leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by cc on 2016/7/16.
 */
public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 1; i < prices.length; i++){

            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                result += diff;
            }
        }

        Map<String, String> map = new HashMap();
        Iterator it = map.entrySet().iterator();

        Map.Entry<String, String> each = (Map.Entry<String, String>)it.next();

        return result;
    }
}
