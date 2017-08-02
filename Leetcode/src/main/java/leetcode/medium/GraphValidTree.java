package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/5/28.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums,-1);
        for(int[] edge : edges){
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);

            if(x == y) return false;
            //make x pointing to y .
            //this does not mean x and y are directly linked.
            //only indicate that x and y are linked somehow.
            nums[x] = y;
        }
        return edges.length == n - 1;
    }

    /**
     * nums[i] = j, means i and j are linked. somehow already.
     * it doesnt keep the edges relation, only know if any two vertex already are linked.
     *
     * nums[i] == -1, means it is the end. so return i.
     * otherwise, keep tracing down until reach the end.
     * */
    public int find(int[] nums, int i){
        if(nums[i] == -1) return i;
        return find(nums, nums[i]);
    }

}
