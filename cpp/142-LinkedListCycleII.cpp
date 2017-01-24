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
    ListNode *detectCycle(ListNode *head) {
        if (!head){
            return head;
        }
        ListNode* slow = head, *fast = head;
        bool cycleDetect = false;
        while (fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast){
                cycleDetect = true;
                break;
            }
        }
        if (cycleDetect == false){
            return NULL;
        }
        fast = head;
        while (fast != slow){
            fast = fast->next;
            slow = slow->next;
        }
        return fast;
    }
};
