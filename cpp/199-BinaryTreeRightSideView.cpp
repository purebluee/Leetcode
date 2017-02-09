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
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        TreeNode* curr = root;
        if (!root) {
            return res;
        }
        queue<TreeNode*> que;
        que.push(root);
        while (!que.empty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode* curr = que.front();
                que.pop();
                if (i == size - 1) {
                    res.push_back(curr->val);
                }
                if (curr->left) {
                    que.push(curr->left);
                }
                if (curr->right) {
                    que.push(curr->right);
                }
            }
        }
        return res;
    }
};
