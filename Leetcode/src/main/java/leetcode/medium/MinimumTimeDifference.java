package leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/3/29.
 */
public class MinimumTimeDifference {

    /**
     * Basic idea is sort the time
     * starting from 1 to the end, calculate the difference.
     * difference can be count as transfer them to minutes, and do substract.
     *
     * special case is the last element,
     * we also need to count the different between this one and the first element.
     * how to count is count(lastTime, 24:00) + count(00:00, firstTime)
     * */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String[] t1 = o1.split(":");
                String[] t2 = o2.split(":");
                return t1[0].equals(t2[0]) ? t1[1].compareTo(t2[1]) : t1[0].compareTo(t2[0]);
            }
        });
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < timePoints.size(); i++){
            int difference = countDiff(timePoints.get(i-1),timePoints.get(i));
            result = Math.min(result, difference);
            if(i == timePoints.size() - 1){
                int diff1 = countDiff(timePoints.get(i), "24:00");
                int diff2 = countDiff("00:00", timePoints.get(0));
                result = Math.min(result, diff1+diff2);
            }
        }
        return result;
    }

    private int countDiff(String preT, String currentT){
        String[] pre = preT.split(":");
        String[] current = currentT.split(":");
        int preH = Integer.parseInt(pre[0]);
        int preM = Integer.parseInt(pre[1]);
        int currentH = Integer.parseInt(current[0]);
        int currentM = Integer.parseInt(current[1]);
        int difference = currentH*60 + currentM - preH*60 - preM;
        return difference;
    }

}
