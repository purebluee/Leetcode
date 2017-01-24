/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (!head){
            return head;
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* fast = dummy, *slow = dummy;
        for (int i = 0; i < n; i++){
            fast = fast->next;
        }
        while (fast && fast->next){
            slow = slow->next;
            fast = fast->next;
        }
        slow->next = slow->next->next;
        return dummy->next;
    }
};
