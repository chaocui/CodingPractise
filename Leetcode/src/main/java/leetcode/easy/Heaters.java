package leetcode.easy;

import java.util.Arrays;

/**
 * Created by cc on 2017/4/19.
 */
public class Heaters {

    /**
     * Basic idea is.
     * 1. sort heaters,
     * 2. find the place of house in heaters array.
     *      Note: Arrays.binarySearch() will return the index if the searched value exists.
     *      if not exists, it will return -insertPosition - 1.
     *      so if index < 0, we get the inserted position is -(index+1)
     * 3. Find the distance between this house with left heater and right heater.
     *    Since to heat this house, we just need to take the min distance.
     *
     * Then we take Math.max(result, Math.min(left, right));
     * */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0) index = -(index+1);
            int left = index > 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
            int right = index <= heaters.length - 1 ? heaters[index] - house : Integer.MAX_VALUE;
            result = Math.max(result, Math.min(left, right));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] house = {1,2,3};
        int[] heater = {2};
        Heaters heaters = new Heaters();
        System.out.println(heaters.findRadius(house,heater));

    }
}
