package leetcode.medium;

import leetcode.util.RandomListNode;

/**
 * Created by cc on 2017/2/19.
 */
public class CopyListWithRandomPointer {

    /*
    * Three steps.
    * 1. Copy each node, right after itself
    * 2. Assign random pointer of each copied node.
    * 3. Separate copied and original.
    * */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode it = head;
        while(it != null){
            RandomListNode copy = new RandomListNode(it.label);
            copy.next = it.next;
            it.next = copy;
            it = it.next.next;
        }

        it = head;
        while(it != null){
            if(it.random != null)
                it.next.random = it.random.next;
            it = it.next.next;
        }

        it = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode temp, copyIt = dummy;
        while(it != null){
            //Save original next pointer.
            RandomListNode oriNext = it.next.next;
            //save the copy node
            temp = it.next;
            //construct copy list.
            //Copy it initialized as dummy, So dummy points to the first node of copy list.
            //Dummy.next is the head of copy. so return dummy.head.
            copyIt.next = temp;
            //Move copy iterator to next;
            copyIt = temp;

            //extract original list.
            it.next = oriNext;
            //Move original iterator.
            it = oriNext;
        }

        return dummy.next;

    }

}
