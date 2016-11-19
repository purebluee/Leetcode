/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0), curr = dummy, notNine = dummy;
        dummy.next = head;
        while (curr != null){
            if (curr.val != 9){
                notNine = curr;
            }
            curr = curr.next;
        }
        notNine.val++;
        notNine = notNine.next;
        while (notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        return dummy.val != 0 ? dummy : dummy.next;
    }
}