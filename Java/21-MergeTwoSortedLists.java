//Iterative:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //1 > 3 > 4 > 6
 //2 > 3 > 5 > 7
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = l1.val < l2.val ? l1 : l2;
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null){
            if (p1 == null){
                curr.next = p2;
                break;
            }
            if (p2 == null){
                curr.next = p1;
                break;
            }
            if (p1.val < p2.val){
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            }else{
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}


//recursive:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
        
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}