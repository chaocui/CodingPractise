package leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/5/28.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}
