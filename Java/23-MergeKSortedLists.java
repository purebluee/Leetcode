/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 1 - 3 - 5 - 7 - 8
 2 - 4 - 6 - 7
 1 - 2 - 3 - 5 - 6
 */
 
 //Priority queue solution
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });
        //add first element of each lists to PQ
        for (ListNode i : lists){
            if (i != null){
                pq.offer(i);
            }
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pq.peek();
        ListNode curr = dummy;
        while (!pq.isEmpty()){
            ListNode tmp = pq.poll();
            curr.next = tmp;
            if (tmp.next != null){
                pq.add(tmp.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}