package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/2/2.
 */
public class PartitionList {

    //Use two separate list less, greater,
    //Then link two list together.
    //Mine is creating new head OBJECT
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        //Two head keep track of beginning of each list.
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head1.next = small;
        head2.next = large;
        //Even you change small and large. but head1.next and head2.next not changing.
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                large.next = head;
                large = large.next;
            }
            //Move head to next first.
            //Dont need to break existing link, since when we modify next, its breaking.
            head = head.next;
        }

        //Merge list
        large.next = null;
        small.next = head2.next.next;
        return head1.next.next;
    }

    //Clean solution
    //This is use the same reference.
    //But only move one reference.
    //Keep the other
    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }


}
