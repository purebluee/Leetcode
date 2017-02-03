/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
    int counter = 0;
    int res = INT_MIN;
public:
    int kthSmallest(TreeNode* root, int k) {
        if (counter < k)
            inOrder(root, k);
        return res;
    }

    void inOrder(TreeNode* curr, int k){
        if (!curr)  return;
        inOrder(curr->left, k);
        counter++;
        if (counter == k){
            res = curr->val;
            return;
        }
        inOrder(curr->right, k);
    }
};
