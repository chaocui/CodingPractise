package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2016/11/1.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {

        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;

        Set<String> dict = new HashSet<String>();

        int area = 0;
        for(int[] points : rectangles){

            int xLB = points[0];
            int yLB = points[1];
            int xTR = points[2];
            int yTR = points[3];

            xMin = Math.min(Math.min(xLB, xTR), xMin);
            xMax = Math.max(Math.max(xLB, xTR), xMax);
            yMin = Math.min(Math.min(yLB, yTR), yMin);
            yMax = Math.max(Math.max(yLB, yTR), yMax);

            area += (xTR - xLB) * (yTR - yLB);

            String point1 = xLB + "," + yLB;
            String point2 = xLB + "," + yTR;
            String point3 = xTR + "," + yLB;
            String point4 = xTR + "," + yTR;
            String corner[] = {point1, point2, point3, point4};

            for(String each : corner){
                if(dict.contains(each)){
                    dict.remove(each);
                }
                else{
                    dict.add(each);
                }
            }
        }

        if(area != (xMax - xMin) * (yMax - yMin)){
            return false;
        }

        if(!dict.contains(xMin+","+yMin) || !dict.contains(xMin+","+yMax) || !dict.contains(xMax+","+yMin) || !dict.contains(xMax+","+yMax) || dict.size() != 4){
            return false;
        }

        return true;
    }
}
