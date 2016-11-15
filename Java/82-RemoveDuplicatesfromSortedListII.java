/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)   return head;
        ListNode dummy = new ListNode(0);
        ListNode fast = head, slow = dummy;
        slow.next = dummy.next = head;
        while (fast != null){
            while (fast.next != null && fast.next.val == fast.val){
                fast = fast.next;
            }
            if (slow.next != fast){
                slow.next = fast.next;
                
            }
            else{
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}