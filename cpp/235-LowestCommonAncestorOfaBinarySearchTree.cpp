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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || p == root || q == root || (root->val > p->val && root->val < q->val)){
            return root;
        }
        if (root->val > p->val && root->val > q->val){
            return lowestCommonAncestor(root->left, p, q);
        }
        if (root->val < p->val && root->val < q->val){
            return lowestCommonAncestor(root->right, p, q);
        }
        return root;
    }
};

//without recursion
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || p == root || q == root || (root->val > p->val && root->val < q->val)){
            return root;
        }
        TreeNode* curr = root;
        while (curr){
            if (curr->val > p->val && curr->val > q->val){
                curr = curr->left;
            }else if (curr->val < p->val && curr->val < q->val){
                curr = curr->right;
            }else{
                return curr;
            }
        }
        return curr;
    }
};
