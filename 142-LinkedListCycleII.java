/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /*
 When fast and slow meet at point p, the length they have run are 'a+2b+c' and 'a+b'.
Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b), then we get 'a==c'.
So when another slow2 pointer run from head to 'q', at the same time, previous slow pointer will run from 'p' to 'q', so they meet at the pointer 'q' together.
e.g., 1->2->3->4->5->6->7->8->9->10-> the cycle begin 3
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode slow2 = head;
                while (slow != slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}