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
public class Solution {
    //hash map
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        if (head.next == head)
            return true;
        Set<ListNode> hs = new HashSet<>();
        ListNode curr = head;
        while (curr.next != null){
            if (hs.contains(curr)){
                return true;
            }else{
                hs.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }
    //slow and fast pointers
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        if (head.next == head)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}