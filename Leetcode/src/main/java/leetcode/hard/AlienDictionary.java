package leetcode.hard;

import leetcode.easy.RangeSumQueryImmutable;

import java.util.*;

/**
 * Created by cc on 2017/5/24.
 */
public class AlienDictionary {

    /**
     * Just compare two adjacent words.
     * traverse each character,
     * if they are equal to each other, skip,
     * if not, see it as a edge of graph, then, get in degree and map edge.
     *
     * Then based on the graph, and indegree we do topology sort.
     * any time, queue size > 1, return "";
     * otherwise, keep going.
     *
     * Topology sort!
     * */
    public String alienOrder(String[] words) {
        //Pre processing
        //create indegree map.
        Map<Character, Set<Character>> edge = new HashMap();
        Map<Character, Integer> indegree = new HashMap<>();
        //initialize all indegree to 0
        for(String s : words){
            for(char c: s.toCharArray())
                indegree.put(c, 0);
        }

        //creating the graph edge and indegree of each vertex.
        for(int i = 0; i < words.length - 1; i++){
            String w = words[i];
            String w1 = words[i+1];
            //loop boundary is the smaller length
            int length = Math.min(w.length(),w1.length());
            for(int j = 0; j < length; j++){
                char c = w.charAt(j);
                char c1 = w1.charAt(j);
                //only process the first non-equal characters. because this determines the sequence.
                if(c != c1){
                    Set<Character> end = new HashSet<>();
                    if(edge.containsKey(c)) end = edge.get(c);
                    //if already exist, no need to increase indegree.
                    if(!end.contains(c1)) {
                        end.add(c1);
                        edge.put(c, end);
                        indegree.put(c1, indegree.getOrDefault(c1, 0) + 1);
                    }
                    break;
                }
            }
        }

        //Starting from indegree 0 vertex.
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character, Integer> each : indegree.entrySet()){
            if(each.getValue() == 0) queue.add(each.getKey());
        }

        //if there are two characters with the same indegree, you cannot decide the sequence of these two.
        while(!queue.isEmpty()){
            //You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
            //Since the description above,
            //which imply that if a has smaller indegree, a should before b.
            Character c = queue.poll();
            result.append(c);
            //update indegree, and put indegree 0 to queue.
            /**
             * Last character in sequence will not be in map,
             * */
            if(edge.containsKey(c)) {
                for (char c1 : edge.get(c)) {
                    indegree.put(c1, indegree.get(c1) - 1);
                    if (indegree.get(c1) == 0) queue.add(c1);
                }
            }
        }
        if(result.length()!=indegree.size()) return "";
        return result.toString();
    }

    public static void main(String[] args) {
        String[] test = {"ca","da","ab"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(test));
    }

}
