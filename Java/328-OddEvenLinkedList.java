/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode preHead1 = null, preHead2 = null;
        ListNode evenHead = head;
        ListNode oddHead = head.next;
        ListNode even = evenHead;
        ListNode odd = oddHead;
        while (even.next != null && odd.next != null){
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return evenHead;
    }
}