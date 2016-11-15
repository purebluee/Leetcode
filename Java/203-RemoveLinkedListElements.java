/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //if (head == null)   return head;
        //if (head.next == null || head.val == val)   return null;
        
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else
            pre = pre.next;
        }
        return preHead.next;
    }
}