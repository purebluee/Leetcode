/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 //Given 1->2->3->4->5->NULL and k = 2,
 //return 4->5->1->2->3->NULL.

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || !head->next || k == 0)
            return head;
        ListNode* curr = head, *newHead = NULL;
        int len = 1;
        while (curr->next) {
            curr = curr->next;
            len++;
        }
        //cout << len;
        k = len - k % len;
        curr->next = head;
        //wrong:
        //curr = curr->next;

        while (curr && k > 0) {
            curr = curr->next;
            k--;
        }
        head = curr->next;
        //VERY IMPORTANT!!
        curr->next = NULL;
        return head;
    }
};
