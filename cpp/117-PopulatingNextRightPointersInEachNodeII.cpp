/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
 /*
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root)
            return;
        TreeLinkNode* head = root; //The left most node in the lower level
        TreeLinkNode* prev = NULL; //The previous node in the lower level
        TreeLinkNode* curr = NULL; //The current node in the upper level
        while (head) {
            curr = head;
            head = NULL;
            prev = NULL;
            while (curr) {
                if (curr->left) {
                    if (prev) {
                        prev->next = curr->left;
                    } else {
                        head = curr->left;
                    }
                    prev = curr->left;
                }
                if (curr->right) {
                    if (prev) {
                        prev->next = curr->right;
                    } else {
                        head = curr->right;
                    }
                    prev = curr->right;
                }
                curr = curr->next;
            }
        }
    }
};
