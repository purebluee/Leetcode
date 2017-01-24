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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> res;
        if (!root){
            return res;
        }
        vector<int> curr;
        dfs(root, sum, res, curr);
        return res;
    }

    void dfs(TreeNode* root, int sum, vector<vector<int>>& res, vector<int>& curr){
        if (!root){
            return;
        }
        curr.push_back(root->val);
        if (root->val == sum && !root->left && !root->right){
            res.push_back(curr);
        }
        dfs(root->left, sum - root->val, res, curr);
        dfs(root->right, sum - root->val, res, curr);
        curr.pop_back();
    }
};
