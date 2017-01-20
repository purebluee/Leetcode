/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//Recursion
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        if (!root->left && !root->right){
            return 1;
        }
        if (!root->left || !root->right){
            return max(minDepth(root->left), minDepth(root->right)) + 1;
        }
        return min(minDepth(root->left), minDepth(root->right)) + 1;
    }
};


 //Iterative DFS
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        if (!root->left && !root->right){
            return 1;
        }
        stack<pair<TreeNode*, int>> s;
        s.push({root, 1});
        int minD = INT_MAX;
        while (!s.empty()){
            pair<TreeNode*, int> currP = s.top();
            s.pop();
            TreeNode* currN = currP.first;
            int currD = currP.second;
            if (!currN->left && !currN->right){
                minD = min(minD, currD);
            }
            if (currN->left){
                s.push({currN->left, currD+1});
            }
            if (currN->right){
                s.push({currN->right, currD+1});
            }
        }
        return minD;
    }
};
