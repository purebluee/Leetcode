/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)  return head;
        ListNode dummy = new ListNode(0);// create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode prev = dummy;// make a pointer pre as a marker for the node before reversing
        for (int i = 1; i < m; i++){
            prev = prev.next;
        }
        ListNode start = prev.next;// a pointer to the beginning of a sub-list that will be reversed
        ListNode reversed = start.next;// a pointer to a node that will be reversed
            
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5        
        for (int i = m; i < n; i++){
            start.next = reversed.next;
            reversed.next = prev.next;
            prev.next = reversed;
            reversed = start.next;
        }
        return dummy.next;
    }
}