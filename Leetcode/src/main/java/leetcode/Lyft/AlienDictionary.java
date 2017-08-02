package leetcode.Lyft;

import java.util.*;

/**
 * Created by cc on 2017/6/26.
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String s : words){
            for(char c : s.toCharArray()){
                indegree.put(c,0);
            }
        }
        for(int i = 1; i < words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    if(!edges.containsKey(c1))
                        edges.put(c1, new ArrayList<Character>());
                    edges.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2)+1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> each : indegree.entrySet()){
            if(each.getValue() == 0)
                queue.add(each.getKey());
        }

        /**
         * Topology sort feature, for all indegree 0 vertex, randomly pick one.
         * */
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            if(edges.containsKey(c)) {
                List<Character> endV = edges.get(c);
                for (char each : endV) {
                    indegree.put(each, indegree.get(each)-1);
                    if (indegree.get(each) == 0)
                        queue.add(each);
                }
            }
        }
        /**
         * if the chars we can sort is less than all the characters, we cannot decide the order.
         * */
        if(result.length() != indegree.size()) return "";
        return result.toString();
    }

    public static void main(String[] args) {
        String[] test = {"wrt","wrf","er","ett","rftt"};
        AlienDictionary ad =  new AlienDictionary();
        System.out.println(ad.alienOrder(test));
    }

}
