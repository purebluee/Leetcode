/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)    return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        ListNode p1 = head;
        ListNode p2 = reverseLinkedList(slow);
        while (p2 != null){
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    
    public ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = head;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}