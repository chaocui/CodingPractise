package leetcode.medium;

/**
 * Created by cc on 2017/3/16.
 */
public class VerifyPreorderSerializationOfaBinaryTree {

    //basically
    //each non null node provide 2 children, 1 parent.
    //each null node provide 0 children, 1 parent.
    //starting from root, its one parent.
    //for each next node. substract 1 since on parent miss, and add 2 if its not null.

    /**
     * Counting children and parent.
     * */
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String[] nodes = preorder.split(",");

        for(String node : nodes){
            //when we meet each new node, we need to minus 1 first.
            //since once we reach this node, means we substract one of the children we added before.
            diff --;
            if(diff < 0) return false;
            if(!node.equals("#"))
                diff+=2;
        }
        return diff == 0;
    }

}
