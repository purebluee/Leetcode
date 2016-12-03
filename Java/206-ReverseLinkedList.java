/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //recursive solution
public class Solution {
    //Iterative!!!!
    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head, prev = null, next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }


    //recursive
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead){
        if (head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = next;
        return reverseList(newHead, head);
    }

    //recursive 2
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}