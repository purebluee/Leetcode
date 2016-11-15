/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)   return head;
        ListNode start = new ListNode();
        start.next = head;
        
        ListNode fast = start;
        ListNode slow = start;
        
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
    }
}