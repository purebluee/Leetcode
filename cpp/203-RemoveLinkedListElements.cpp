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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* curr = dummy;
        while (curr && curr->next){
            if (curr->next->val == val){
                curr->next = curr->next->next;
            }else{
                curr = curr->next;
            }
        }
        return dummy->next;
    }
};
