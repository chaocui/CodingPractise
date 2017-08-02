package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by cc on 2017/4/2.
 */
public class MostFrequentSubtreeSum {

    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer, Integer> count = new HashMap<>();
        getResult(root, count);
        List<Integer> temp = new ArrayList<>();
        for(Map.Entry<Integer, Integer> each : count.entrySet()){
            if(each.getValue() == max)
                temp.add(each.getKey());
        }
        int[] result = new int[temp.size()];
        for(int i = 0;i < result.length; i++)
            result[i] = temp.get(i);
        return result;
    }

    //Keep track of max, so we can filter out count based on max.
    //use map to memory result to avoid recalculation
    //count is value-frequency map which used to filter out result.
    public int getResult(TreeNode node, Map<Integer,Integer> count){
        if(node == null) return 0;

        int left = getResult(node.left,count);
        int right = getResult(node.right,count);

        int result = node.val + left + right;
        int currentCount =  count.getOrDefault(result,0)+1;
        count.put(result, currentCount);
        max = Math.max(currentCount, max);
        return result;
    }
}
