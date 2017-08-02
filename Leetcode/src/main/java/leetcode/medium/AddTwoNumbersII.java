package leetcode.medium;

import leetcode.util.ListNode;

import java.util.Stack;

/**
 * Created by cc on 2017/4/7.
 */
public class AddTwoNumbersII {

    /**
     * Use stack to calculate, then form the list.
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null || l2 != null){
            if(l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            if(l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        /**
         * Last two steps can be merged.
         * can insert each result after head;
         * */
        ListNode dummy = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = 0;
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            //s3.push((sum+carry)%10);
            ListNode temp = new ListNode((sum+carry)%10);
            temp.next = dummy.next;
            dummy.next = temp;
            carry = (sum+carry)/10;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}
