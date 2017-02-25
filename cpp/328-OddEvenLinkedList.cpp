/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 //      c1 c2
 //Given 1->2->3->4->5->NULL,
 //return 1->3->5->2->4->NULL.
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (!head || !head->next) {
            return head;
        }
        ListNode* head2 = head->next;
        ListNode* odd = head, *even = head2;
        while (odd->next && even->next) {
            odd->next = odd->next->next;
            even->next = even->next->next;
            odd = odd->next;
            even = even->next;
        }
        odd->next = head2;
        return head;
    }
};
