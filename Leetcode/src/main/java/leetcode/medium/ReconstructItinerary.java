package leetcode.medium;
import javafx.scene.layout.Priority;

import java.util.*;

/**
 * Created by cc on 2017/2/14.
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> processed = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
            String[] each = tickets[i];
            String key = each[0];
            String value = each[1];
            if(processed.containsKey(key)){
                processed.get(key).add(value);
            }
            else{
                PriorityQueue<String> pq = new PriorityQueue<String>();
                pq.add(value);
                processed.put(key,pq);
            }
        }

        Stack<String> track = new Stack<String>();
        List<String> result = new ArrayList<String>();
        track.push("JFK");
        while(!track.isEmpty()){
            while(processed.containsKey(track.peek()) && !processed.get(track.peek()).isEmpty()){
                track.push(processed.get(track.peek()).poll());
            }
            result.add(0, track.pop());
        }
        return result;
    }

}
