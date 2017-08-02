package leetcode.hard;

import leetcode.util.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/10.
 */
public class MaxPointsOnALine {

    /**
     * Keep track of the slope using map.
     * O(n^2)
     * */
    public int maxPoints(Point[] points) {
        if(points.length <= 2) return points.length;
        int result = 0;

        for(int i = 0; i < points.length; i++){
            //count max count for each point.
            //Basically, use slope which is double as hash map key is not reliable.
            //Since the precision problem.
            //So we calculate xDiff and yDiff of each two points.
            //then we find the gcd of xDiff and yDiff, then we set xDiff/=gcd, yDiff/=gcd.
            //Since any two points with same slope, after divide the gcd, there will always be the same xDiff and yDiff,
            //so we use yDiff-xDiff string as key of the has map to mark the slope.
            Map<String, Integer> track = new HashMap<>();
            int samePoint = 0;
            int sameX = 1; //this need to be count separately, since same x will lead to divided by 0; same X will be initialized as 1.
            for(int j = 0; j < points.length; j++){
                if(i != j) {
                    if(points[j].y == points[i].y && points[j].x == points[i].x)
                        samePoint ++;
                    if(points[j].x == points[i].x){
                        sameX ++;
                        continue;
                    }
                    int yDiff = points[j].y - points[i].y;
                    int xDiff = points[j].x - points[i].x;
                    int gcd = generateGCD(xDiff, yDiff);
                    xDiff /= gcd;
                    yDiff /= gcd;
                    String key = ""+yDiff+"-"+xDiff;
                    track.put(key, track.getOrDefault(key, 1) + 1);
                    result = Math.max(result, track.get(key) + samePoint);
                }
            }
            result = Math.max(result, sameX);
        }
        return result;
    }

    private int generateGCD(int a, int b){
        if(b == 0) return a;
        return generateGCD(b, a%b);
    }

}
