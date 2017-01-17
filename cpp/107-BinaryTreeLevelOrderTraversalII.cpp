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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        if (!root){
            return res;
        }
        queue<TreeNode*> queue;
        queue.push(root);
        
        while (!queue.empty()){
            vector<int> level;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode* curr = queue.front();
                queue.pop();
                level.push_back(curr->val);
                if (curr->left){
                    queue.push(curr->left);
                }
                if (curr->right){
                    queue.push(curr->right);
                }
            }
            res.push_back(level);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};