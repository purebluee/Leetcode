/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallH = new ListNode(0), biggerH = new ListNode(0);
        ListNode smaller = smallH, bigger = biggerH;
        while(head != null){
            if (head.val < x){
                smaller = smaller.next = head;
            }else{
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        smaller.next = biggerH.next;
        bigger.next = null;
        return smallH.next;
    }
}