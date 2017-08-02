package leetcode.Airbnb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cc on 2017/6/30.
 */
public class MinimumPointsTraverseGraph {

    /**
     * Low holds for each vertex, the dfs number it can trace back to.
     * dfsn holds the dfs number(sequence)
     * sccno holds the strong connected component vertex and its number. vertex has the same value are the some component
     * */
    Map<Integer, Integer> low = new HashMap<>();
    Map<Integer, Integer> dfsn = new HashMap<>();
    Map<Integer, Integer> sccno = new HashMap<>();
    Map<Integer, Integer> idCount = new HashMap<>();
    int dfsCount = 0, sccCount=0;
    Stack<Integer> stack = new Stack<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public void dfs(int n){
        dfsCount++;
        low.put(n, dfsCount);
        dfsn.put(n, dfsCount);
        stack.push(n);
        for(int i : graph.get(n)){
            //if not visited, visit and update low u to be u and v track back, the smaller one.
            if(!low.containsKey(i)){
                dfs(i);
                low.put(n, Math.min(low.get(n), low.get(i)));
            }
            //if visited, but still in stack, means it is not grouped yet.
            //means that sccno does not contain this.
            //if visited, means that there is cycle, low u might be trace back to the dfs number of i.
            //we take the minimum.
            else if(!sccno.containsKey(i)){
                low.put(n, Math.min(low.get(n), dfsn.get(i)));
            }
        }
        //after dfs done for n. if trace back is itself.
        if(low.get(n) == dfsn.get(n)){
            sccCount++;
            int v = -1;
            while(v != n){
                v = stack.pop();
                sccno.put(v, sccCount);
            }
        }
    }
    //after dfs, we group all strong connected components.
    public int countIndegree(int n){
        //if only one strong connected component
        if(sccCount == 1) return 1;
        for(int i = 1; i <= n; i++){
            for(int j : graph.get(i)){
                //if i j not belong to same component, but they are connected.
                //means the component j belongs to, indegree is not 0.
                if(sccno.get(i) != sccno.get(j)){
                    idCount.put(sccno.get(j), idCount.getOrDefault(sccno.get(j),0) + 1);
                }
            }
        }
        //id count hold the component that has non-0 indegree, so we substract.
        return sccCount - idCount.size();
    }
    //n is the number of vertex
    public void find(int n){
        for(int i = 1; i <= n; i++){
            dfs(i);
        }
    }
}
