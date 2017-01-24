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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if (!root){
            return res;
        }
        string init = to_string(root->val);
        traverse(root, init, res);
        return res;
    }

    void traverse(TreeNode* root, string curr, vector<string> &res){
        if (!root->left && !root->right){
            res.push_back(curr);
        }
        if (root->left){
            traverse(root->left, curr + "->" + to_string(root->left->val), res);
        }
        if (root->right){
            traverse(root->right, curr + "->" + to_string(root->right->val), res);
        }
    }
};
