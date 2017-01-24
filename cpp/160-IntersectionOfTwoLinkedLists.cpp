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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (!headA || !headB)   return NULL;
        ListNode* currA = headA;
        ListNode* currB = headB;
        while (currA && currB && currA != currB){
            currA = currA->next;
            currB = currB->next;
            if (currA == currB){
                break;
            }
            if (!currA){
                currA = headB;
            }
            if (!currB){
                currB = headA;
            }
        }
        return currA;
    }
};
