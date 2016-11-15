/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            if (prev != null || prev.next != null || prev.next.val >= curr.val){
                prev = dummy;
            }
            while (prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}