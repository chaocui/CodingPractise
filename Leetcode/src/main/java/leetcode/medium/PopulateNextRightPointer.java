package leetcode.medium;

/**
 * Created by cc on 2016/12/4.
 */
public class PopulateNextRightPointer {

    public class TreeLinkNode{
        int val;
        TreeLinkNode left, right ,next;
        TreeLinkNode(int x){
            val = x;
        }
    }

    //Two additional pointer
    //one is previous level start,
    //one is current level start,
    //Since it is perfect binary tree,
    /**
     * Basic idea,
     * Keep track of level i
     * use level i to populate level i+1 next.
     * Two variable.
     * 1. Keep track of level i beginning.
     * 2. Iterator loop through level i, to populate level i+1. use left and right children.
     * After the loop, move the beginning to level i+1.
     * */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode pre = root;
        TreeLinkNode current = null;
        //stop looping if there is not level i+1;
        while(pre.left != null){
            //set iterator to level i. iterator is still the previous level.
            current = pre;
            //utilise left, right children to populate next pointer.
            while(current != null){
                current.left.next = current.right;
                if(current.next != null) current.right.next = current.next.left;
                current = current.next;
            }
            //Move to beginning of next level.
            pre = pre.left;
        }
    }
}
