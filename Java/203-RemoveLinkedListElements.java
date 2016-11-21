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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}