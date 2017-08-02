package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/5/16.
 */
public class SequenceReconstruction {

    //BFS Topological Sort
    //拓扑排序
    //用hashmap keep track of 各个顶点的入度。
    //找到入度为0的点的集合。
    //如果入度为0的点集合size不是1，则返回 false, because this means that there are couple vertex can be the starting point.
    //取出入度为0的点.
    //check 当前点是否为对应orignal的位置的数，如果不是 返回false， 如果index out of bound, 返回false
    //如果pass这步 继续进行拓扑排序
    //找到这个点 指向的点, 在indegree里减去1. 因为该点已经satisfy了.
    //把indegree为0的点加入queue
    //最后 看index是否恰好是org.length && index == map.size(); 第二个check保证所有的数在org里都cover到

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap();

        //constructing graph, linked list representation.
        for(List<Integer> seq : seqs){
            if(seq.size() == 1){
                if(!edges.containsKey(seq.get(0))){
                    edges.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            }
            else{
                //loop through the second last vertex
                for(int i = 0; i < seq.size() - 1; i++){
                    //check every two points
                    //initialize them as starting vertex and indegree as 0.
                    if(!edges.containsKey(seq.get(i))){
                        edges.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }
                    if(!edges.containsKey(seq.get(i+1))){
                        edges.put(seq.get(i+1), new HashSet<>());
                        indegree.put(seq.get(i+1), 0);
                    }
                    //add end vertex to starting vertex.
                    //if successful, add 1 to indegree
                    if(edges.get(seq.get(i)).add(seq.get(i+1))){
                        indegree.put(seq.get(i+1), indegree.get(seq.get(i+1)) + 1);
                    }
                }
            }
        }
        //Done graph creation.

        int index = 0;
        Queue<Integer> queue = new LinkedList();
        //add the vertex with indegree 0.
        for(Map.Entry<Integer, Integer> each : indegree.entrySet()){
            if(each.getValue() == 0) queue.offer(each.getKey());
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            //if multiple indegree 0, means these vertex does not have strict sequence.
            if(size > 1) return false;
            int current = queue.poll();
            //if this position is not the same number in org or index exceeding, return false.
            if(index == org.length || current != org[index++]) return false;
            for(int end : edges.get(current)){
                //reduce the indegree of the ending point of current starting point.
                indegree.put(end, indegree.get(end) - 1);
                //if it becomes 0, added to queue.
                if(indegree.get(end) == 0) queue.offer(end);
            }
        }
        //if process the same length as org, && in seqs, it covers all vertex in org.
        return index == org.length && index == edges.size();
    }


}
