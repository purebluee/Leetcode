/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */

 //perfect binary tree
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root){
            return;
        }
        TreeLinkNode* curr = root;

        while (curr){
            TreeLinkNode* next = curr;
            while (next){
                if (next->left){
                    next->left->next = next->right;
                }
                if (next->right && next->next){
                    next->right->next = next->next->left;
                }
                next = next->next;
            }
            curr = curr->left;
        }
    }
};
