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
    //Hash map
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        if (head.next == head){
            return head;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr.next != null){
            if (set.contains(curr)){
                return curr;
            }else{
                set.add(curr);
            }
            curr = curr.next;
        }
        return null;
    }
    //my two pointer sol
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        if (head.next == head){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
            if (fast == null || fast.next == null){
                return null;
            }
        }
        slow = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    //two pointers
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