package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/5/27.
 */
public class CourseScheduleII {

    //Its so clear that this is a topology sort.
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses == 1) return new int[]{0};

        List<Integer> result = new ArrayList<>();
        int index = 0;

        Map<Integer, Set<Integer>> edge = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i = 0; i < numCourses; i++)
            indegree.put(i,0);

        for(int[] e : prerequisites){
            //increase first element indegree by 1.
            //second either initialize or remain the same.
            indegree.put(e[0], indegree.get(e[0])+1);
            Set<Integer> v = new HashSet<>();
            if(edge.containsKey(e[1])) v = edge.get(e[1]);
            v.add(e[0]);
            edge.put(e[1],v);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> each : indegree.entrySet()){
            if(each.getValue() == 0) queue.add(each.getKey());
        }

        //no starting point, cannot finish
        if(queue.isEmpty()) return new int[]{};

        while(!queue.isEmpty()){
            int v = queue.poll();
            result.add(v);
            if(edge.containsKey(v)){
                for(int i : edge.get(v)){
                    indegree.put(i, indegree.get(i)-1);
                    if(indegree.get(i) == 0) queue.add(i);
                }
            }
        }

        //if there is cycle, means at some point, queue will be empty but not all courses are in the result.
        //so if result.size < numCourse, there is no way to finish.
        //otherwise, return result.
        if(result.size() < numCourses) return new int[]{};
        return result.stream().mapToInt(i->i).toArray();
    }
}
