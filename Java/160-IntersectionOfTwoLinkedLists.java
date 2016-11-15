/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //regular constant space, O(n) time
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode currA = new ListNode(0), currB = new ListNode(0);
        currA.next = headA;
        currB.next = headB;
        while (currA.next != null){
            currA = currA.next;
            lenA++;
        }
        while (currB.next != null){
            currB = currB.next;
            lenB++;
        }
        while (lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB){
            headB = headB.next;
            lenB--;
        }
        while (headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        if (headA != null){
            return headA;
        }else{
            return null;
        }
    }

    //Trick: without len
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        if (headA == null || headB == null) return null;
        while (p1 != null && p2 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            
            if (p1 == p2)   return p1;
            
            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
        }
        return p1;
    }
}