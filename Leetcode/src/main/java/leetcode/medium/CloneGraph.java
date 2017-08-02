package leetcode.medium;

import leetcode.util.UndirectedGraphNode;

import java.util.*;

/**
 * Created by cc on 2017/5/28.
 */
public class CloneGraph {

    /**
     * BFS
     *
     * While traverse graph,
     * Use a map to keep track which node is created
     * --if it is already created, we dont need to put into queue again.
     * --if not, we create it, put into track map, add to queue.
     * 1. then for current node, use label to get created node.
     * 2. based on each neighbour label, add created neighbour to copy node.
     * */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        Queue<UndirectedGraphNode> original = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> alreadyCreated = new HashMap<>();

        UndirectedGraphNode result = new UndirectedGraphNode(node.label);

        original.add(node);
        alreadyCreated.put(result.label, result);

        while(!original.isEmpty()){
            UndirectedGraphNode n = original.poll();
            for(int i = 0; i < n.neighbors.size(); i++){
                int l = n.neighbors.get(i).label;
                if(!alreadyCreated.containsKey(l)){
                    alreadyCreated.put(l, new UndirectedGraphNode(l));
                    original.add(n.neighbors.get(i));
                }
                alreadyCreated.get(n.label).neighbors.add(alreadyCreated.get(l));
            }
        }
        return result;
    }
}
