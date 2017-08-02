package TwoSigma.QuestionSet1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2016/8/28.
 */
public class DeleteSubTree {

    public class TreeNode{
        boolean valid;
        int parentIndex;
        int value;
        public TreeNode(int value, int parentIndex){
            this.parentIndex = parentIndex;
            this.value = value;
        }
    }

    public void deleteChildren(int node, TreeNode[] tree){
        Set<Integer> deleteCandidate = new HashSet<Integer>();
        Set<Integer> notCandidate = new HashSet<Integer>();

        for(int i = 0; i < tree.length; i++){
            if(deleteCandidate.contains(i) || notCandidate.contains(i)){
                continue;
            }
            else{
                int tempIt = i;
                Set<Integer> temp = new HashSet<Integer>();
                temp.add(tempIt);
                boolean candidate = false;
                while(true){
                    if(deleteCandidate.contains(tempIt) || tempIt == node){
                        candidate = true;
                        break;
                    }
                    else if(notCandidate.contains(tempIt) || tempIt == -1){
                        candidate = false;
                        break;
                    }
                    temp.add(tempIt);
                    tempIt = tree[tempIt].parentIndex;
                }
                if(candidate){
                    deleteCandidate.addAll(temp);
                }
                else{
                    notCandidate.addAll(temp);
                }
            }
        }

        for(Integer each : deleteCandidate){
            tree[each.intValue()].valid = false;
        }
    }
}
