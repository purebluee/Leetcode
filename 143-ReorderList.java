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
        if (head == null){
            return;
        }
        //ListNode pre1 = new ListNode(0), pre2 = new ListNode(0);
        //pre1.next = head; 
        //pre2.next = head.next;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        mergeList(head, head2);
    }
    
    private void mergeList(ListNode head1, ListNode head2){
        while (head1 != null && head2 != null){
            ListNode p1 = head1.next, p2 = head2.next;
            head1.next = head2;
            if (p1 == null){
                return;
            }
            head2.next = p1;
            head1 = p1;
            head2 = p2;
        }
    }
    
    private ListNode reverseList(ListNode head){
        ListNode pre = null, curr = head, next = null;
        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}