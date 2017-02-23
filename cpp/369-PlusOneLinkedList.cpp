/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//1->2->3->9->3->9->9->NULL
//9->9->9->NULL
//slow: last digit before 9.
class Solution {
public:
    ListNode* plusOne(ListNode* head) {
        if (!head)
            return head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast) {
            if (fast->val != 9) {
                slow = fast;
                fast = fast->next;
            } else {
                fast = fast->next;
            }
        }
        if (slow->val != 9) {
            slow->val++;
            slow = slow->next;
            while (slow) {
                slow->val = 0;
                slow = slow->next;
            }
            return dummy->next;
        } else {
            dummy->val = 1;
            while (slow) {
                slow->val = 0;
                slow = slow->next;
            }
            return dummy;
        }
    }
};

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//1->2->3->9->3->9->9->NULL
//reversed LL:
//9->9->3->9->3->2->1->NULL
//9->9->9->NULL
class Solution {
public:
    ListNode* plusOne(ListNode* head) {
        if (!head)
            return head;
        ListNode* newHead = reverseList(head);
        ListNode* curr = newHead;
        if (curr->val != 9) {
            curr->val++;
            return reverseList(newHead);
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = newHead;
        while (curr && curr->val == 9) {
            curr->val = 0;
            curr = curr->next;
        }
        if (curr) {
            //curr is at the first non-9 node
            curr->val++;
            return reverseList(newHead);
        } else {
            //all 9s
            dummy->val = 1;
            return dummy;
        }
    }

    ListNode* reverseList(ListNode* head) {
        ListNode* prev = NULL, *curr = head, *next = NULL;
        while (curr) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};
