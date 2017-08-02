package leetcode.util;

/**
 * Created by cc on 2017/4/21.
 */
public class Utils {

    public static ListNode convert(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int n : nums){
            ListNode temp = new ListNode(n);
            tail.next = temp;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        while(head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = Utils.convert(new int[]{1,2,3,4});
        Utils.printList(head);
        System.out.println();
    }
}
