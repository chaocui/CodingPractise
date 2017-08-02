package leetcode.medium;

/**
 * Created by cc on 2017/3/9.
 */
public class PopulatingNextRightPointersinEachNodeII {

    public class TreeLinkNode{
        int val;
        TreeLinkNode left, right ,next;
        TreeLinkNode(int x){
            val = x;
        }
    }

    //Same idea as Populating Next Right pointer
    //Difference is that in I, its perfect, we dont have to do null check and mark the start of the next level.
    //So for this issue.
    //1. We need to mark the start of next level. which is the first not null child.
    //2. We need a iterator to iterate through and populate the next
    //3. Once inner loop is done, we set level to the start of the next level.
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while(level != null){
            TreeLinkNode levelStart = null, it = null;
            boolean headSet = false;
            while(level != null){
                if(level.left != null){
                    if(!headSet){
                        levelStart = level.left;
                        it = level.left;
                        headSet = true;
                    }
                    else{
                        it.next = level.left;
                        it = it.next;
                    }
                }
                if(level.right != null){
                    if(!headSet){
                        levelStart = level.right;
                        it = level.right;
                        headSet = true;
                    }
                    else{
                        it.next = level.right;
                        it = it.next;
                    }
                }
                level = level.next;
            }
            level = levelStart;
        }
    }
}