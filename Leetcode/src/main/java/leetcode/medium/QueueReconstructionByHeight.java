package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cc on 2017/1/8.
 */
public class QueueReconstructionByHeight {
    //Sort by height,
    //for same height, sort by number
    //After sorting.
    //loop though the list, for each element, insert to index based on number k.
    //Because k means how many people taller than current. and all previous are taller, so just insert it at index current[1]
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        //Height ascending.
        //K, descending.
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return a1[0] == a2[0] ? a1[1] - a2[1] : a2[0] - a1[0];
            }
        });

        for(int[] each : people){
            result.add(each[1], each);
        }

        return result.toArray(new int[people.length][]);
    }
}
