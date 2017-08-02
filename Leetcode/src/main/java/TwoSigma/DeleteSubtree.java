package TwoSigma;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/8/10.
 */
public class DeleteSubtree {

    public static class TreeNode{
        int parentIndex;
        char value;
        boolean valid = true;
        public TreeNode(int parentIndex, char value){
            this.parentIndex = parentIndex;
            this.value = value;
        }
    }

    public void deleteNode(TreeNode[] nodes, int index){

        Map<Integer, TreeNode> candidate = new HashMap<Integer, TreeNode>();
        Map<Integer, TreeNode> notCandidate = new HashMap<Integer, TreeNode>();
        candidate.put(index, nodes[index]);
        for(int i = 0; i < nodes.length; i++){
            if(candidate.containsKey(i) || notCandidate.containsKey(i)){
                continue;
            }
            else{
                Map<Integer, TreeNode> tempCandidate = new HashMap();
                tempCandidate.put(i,nodes[i]);
                TreeNode it = nodes[i];
                boolean valid = false;
                while(true){
                    if(candidate.containsKey(it.parentIndex) || it.parentIndex == index){
                        valid = true;
                        break;
                    }
                    else if(notCandidate.containsKey(it.parentIndex) || it.parentIndex == -1){
                        valid = false;
                        break;
                    }
                    else{
                        it = nodes[it.parentIndex];
                    }
                }
                if(valid){
                    candidate.putAll(tempCandidate);
                }else{
                    notCandidate.putAll(tempCandidate);
                }
            }
        }
        for(Map.Entry<Integer, TreeNode> each : candidate.entrySet()){
            each.getValue().valid = false;
        }
    }

    public static void main(String[] args){

        TreeNode A = new TreeNode(-1,'A');
        TreeNode B = new TreeNode(4,'B');
        TreeNode C = new TreeNode(1,'C');
        TreeNode D = new TreeNode(1,'D');
        TreeNode E = new TreeNode(4,'E');
        TreeNode F = new TreeNode(6,'F');
        TreeNode G = new TreeNode(3,'G');

        TreeNode nodes[] = {C,B,G,D,A,F,E};

        DeleteSubtree ds = new DeleteSubtree();
        ds.deleteNode(nodes, 3);

        for(TreeNode node : nodes){
            if(node.valid) {
                System.out.println(node.value);
            }
        }
    }

}
