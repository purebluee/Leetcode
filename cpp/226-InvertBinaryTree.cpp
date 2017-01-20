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
    TreeNode* invertTree(TreeNode* root) {
        if (!root){
            return root;
        }
        TreeNode* tmp = root->left;
        root->left = invertTree(root->right);
        root->right = invertTree(tmp);
        return root;
    }
};

//Iterative
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
    TreeNode* invertTree(TreeNode* root) {
        if (!root){
            return root;
        }
        stack<TreeNode*> s;
        s.push(root);
        while (!s.empty()){
            TreeNode* curr = s.top();
            s.pop();
            TreeNode* tmp = curr->left;
            curr->left = curr->right;
            curr->right = tmp;
            if (curr->left){
                s.push(curr->left);
            }
            if (curr->right){
                s.push(curr->right);
            }
        }
        return root;
    }
};
