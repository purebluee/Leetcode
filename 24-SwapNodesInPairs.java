/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null) {
            return null;
        }
        ListNode newhead = new ListNode(-1);//dummy
        newhead.next = head;
        ListNode temp = newhead;
        
        ListNode one = null;
        ListNode two = null;
        
        // {dummy->1->2->3->4->null}
        //explanation for one loop rest are same.
        
        while(temp.next!= null && temp.next.next!=null) {
            // temp points to dummy in the beginning.
            // one -> 1
            one = temp.next;
            //two -> 2
            two = temp.next.next;
            // 1-> = 2.next = 3;
            one.next=two.next;
            // 2-> = 1
            two.next = one;
            //now dummy should point to 2
            //if the below is not done dummy->1;
            temp.next = two;
            // temp was pointing to dummy
            //temp->1 
            temp = one;
            
            // now { dummy->2->1->3->4 } 
            
        }
        return newhead.next;
    }
}