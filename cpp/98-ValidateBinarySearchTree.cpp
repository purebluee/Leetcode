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
    bool isValidBST(TreeNode* root) {
        if (!root)
            return true;
        return isValidBST(root, NULL, NULL);
    }
    
    bool isValidBST(TreeNode* root, TreeNode* minNode, TreeNode* maxNode){
        if (!root)
            return true;
        if (minNode && root->val <= minNode->val || maxNode && root->val >= maxNode->val)
            return false;
        bool left = isValidBST(root->left, minNode, root);
        bool right = isValidBST(root->right, root, maxNode);
        return left && right;
    }
};

//Iterative solution:
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
    bool isValidBST(TreeNode* root) {
        if (!root)
            return true;
        
        stack<TreeNode*> stack;
        TreeNode* p = root;
        
        long prev = LLONG_MIN;

        while (p || !stack.empty()){
            if (p){
                stack.push(p);
                p = p->left;
            }else{
                TreeNode* curr = stack.top();
                stack.pop();
                if (curr->val <= prev){
                    return false;
                }
                prev = curr->val;
                p = curr->right;
            }
        }
        return true;
    }
};