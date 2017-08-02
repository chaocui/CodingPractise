package leetcode.Uber;

import leetcode.util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by cc on 2017/6/14.
 */
public class CloneGraph {

    /**
     * Basic idea is use a map to keep track of which node is created.
     * if it is already created, we just add its reference to its dependent.
     * if not, we create it and add to map.
     * */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> created = new HashMap<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        created.put(node.label, result);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            for(int i = 0; i < n.neighbors.size(); i++){
                int label = n.neighbors.get(i).label;
                /**
                 * If it is created, means that it has been added to the queue already.
                 * means that it will be processed or already processed.
                 * So dont need to process again.
                 * only add relations to current node is enough.
                 * */
                if(!created.containsKey(label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(label);
                    created.put(label, newNode);
                    queue.offer(n.neighbors.get(i));
                }
                created.get(n.label).neighbors.add(created.get(label));
            }
        }
        return result;
    }
}
