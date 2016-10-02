/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        ListNode preMid = p1, preCurr = p1.next;
        while (preCurr.next != null){
            ListNode curr = preCurr.next;
            preCurr.next = curr.next;
            curr.next = preMid.next;
            preMid.next = curr;
        }
        //don't understand!
        p1 = head;
        p2 = preMid.next;
        while (p1 != preMid){
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}