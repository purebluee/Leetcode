/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 //two situations:
 //1: 1->2->3->4->5
 //2: 1->2->3->4->5->6
 
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (!head || !(head->next)){
            return true;
        }
        ListNode* slow = head, *fast = head;
        while (fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        if (fast){
            slow = slow->next;
        }
        ListNode* rev = reverseList(slow);
        while (rev){
            if (head->val != rev->val){
                return false;
            }
            head = head->next;
            rev = rev->next;
        }
        return true;
    }

private:
    ListNode* reverseList(ListNode* head){
        ListNode* prev = NULL, *curr = head, *next = NULL;
        while (curr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};