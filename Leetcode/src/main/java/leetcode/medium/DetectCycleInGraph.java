package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/4/30.
 */
public class DetectCycleInGraph {
    /**
     *
     * Detect cycle in graph,
     * Basic idea is white, grey, black.
     * White, all non visited vertex
     * Grey, visited in current recursion stack
     * Black, visited in overall but not forming loop.
     *
     * 黑白灰
     *
     * Basic idea.
     * Three sets.
     * white, grey, black.
     * while holds all vertex that is a starting point, and not visited.
     * grey holds the vertex that in current looping stack.
     * black holds all the vertex that not forming loop but visited.
     *
     * if found some vertex in grey, meaning we found a loop.
     * if found some vertex in black, meaning this current vertex won't lead to a loop, just skip.
     *
     * Steps:
     * 1. fill in white, while we doing this, use another map to track each vertex and its adjacents. using map<Integer, List<Integer>>
     * 2. Loop through keys in white
     * if it is still in white, start dfs from current vertex.
     *
     * DFS recursive steps,
     * 1. remove from white.
     * 2. add to grey, its current stack.
     * 3. Find all adjacent vertex,
     *      if they are not in grey, recursive.
     *      if they are in grey, there is loop,
     *      if they are in black, ignore them.
     * if reach the end.
     * meaning this one does not form loop, remove from grey, add to black. return false.
     * */

    public static class Event{
        int winner;
        int loser;
        public Event(int winner, int loser){
            this.winner = winner;
            this.loser = loser;
        }
    }
    public boolean hasCycle(List<Event> list){
        Set<Integer> white = new HashSet<>();
        Set<Integer> grey = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        Map<Integer, List<Integer>> adjacent = new HashMap<Integer, List<Integer>>();
        for(Event each : list){
            if(white.contains(each.winner))
                adjacent.get(each.winner).add(each.loser);
            else{
                List<Integer> losers = new LinkedList<>();
                losers.add(each.loser);
                adjacent.put(each.winner, losers);
                white.add(each.winner);
            }
        }

        //This is needed to avoid concurrentModification Exception.
        //Cannot loop through white and modify it.
        //Copy it to another array, and loop through the array
        Integer[] vertexs = new Integer[white.size()];
        white.toArray(vertexs);
        for(int i : vertexs){
            if(white.contains(i)){
                if(dfs(i, white, grey, black, adjacent))
                    return true;
            }
        }
        return false;
    }

    //We cannot put white and adjacent together, if we did, we cannot remove from white,
    // otherwise we will loose information while we recursion
    //We are not modifying adjacent map,
    //Only modify three other tracker set.
    public boolean dfs(int currentV, Set<Integer> white, Set<Integer> grey, Set<Integer> black, Map<Integer, List<Integer>> adjacent){
        if(!white.contains(currentV)){
            black.add(currentV);
            return false;
        }
        white.remove(currentV);
        grey.add(currentV);
        for(int i : adjacent.get(currentV)){
            if(white.contains(i)){
                if(dfs(i, white, grey, black, adjacent))
                    return true;
            }
            else if(grey.contains(i))
                return true;
            else if(black.contains(i))
                continue;
        }
        grey.remove(currentV);
        black.add(currentV);
        return false;
    }

    public static void main(String[] args) {
        Event e = new Event(1, 2);
        Event e1 = new Event(1, 3);
        Event e2 = new Event(1, 4);
        Event e3 = new Event(1, 5);
        Event e4 = new Event(2, 6);
        Event e5 = new Event(2, 7);
        Event e6 = new Event(2, 8);
        Event e7 = new Event(3, 6);
        Event e8 = new Event(3, 7);
        Event e9 = new Event(6, 1);
        Event e10 = new Event(7, 2);
        List<Event> events = new ArrayList<>();
        events.add(e);
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
        events.add(e6);
        events.add(e7);
        events.add(e8);
        events.add(e9);
        events.add(e10);
        DetectCycleInGraph dcig = new DetectCycleInGraph();
        System.out.println(dcig.hasCycle(events));
    }


}
