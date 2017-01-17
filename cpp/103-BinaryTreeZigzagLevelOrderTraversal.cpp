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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (!root){
            return res;
        }
        queue<TreeNode*> queue;
        queue.push(root);
        int level = 0;
        
        while (!queue.empty()){
            vector<int> currLevel;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode* curr = queue.front();
                queue.pop();
                currLevel.push_back(curr->val);
                if (curr->left){
                    queue.push(curr->left);
                }
                if (curr->right){
                    queue.push(curr->right);
                }
            }
            if (level % 2 != 0){
                reverse(currLevel.begin(), currLevel.end());
            }
            res.push_back(currLevel);
            level++;
        }
        return res;
    }
};

//recursion
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (!root){
            return res;
        }
        traverse(root, res, 0);
        return res;
    }
    
    void traverse(TreeNode* root, vector<vector<int>> &res, int level){
        if (!root){
            return;
        }
        
        if (level >= res.size()){
            vector<int> tmp;
            res.push_back(tmp);
        }
        
        if (level % 2 == 0){
            res[level].push_back(root->val);
        }else{
            res[level].insert(res[level].begin(), root->val);
        }
        
        traverse(root->left, res, level+1);
        traverse(root->right, res, level+1);
    }
};