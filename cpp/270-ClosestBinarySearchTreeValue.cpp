/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 /*wrong solution
class Solution {
public:
    int closestValue(TreeNode* root, double target) {
        if (!root) {
            return -1;
        }
        TreeNode* curr = root;
        double minDiff = abs(root->val - target);
        while (curr) {
            cout << minDiff << endl;
            if (target > curr->val && curr->right && abs(curr->right->val - target) < minDiff) {
                minDiff = abs(curr->right->val - target);
                curr = curr->right;
            } else if (target < curr->val && curr->left && abs(curr->left->val - target) < minDiff) {
                minDiff = abs(curr->left->val - target);
                curr = curr->left;
            } else {
                break;
            }
        }
        return curr->val;
    }
};
*/

//Use res variable to keep track of correct value!
class Solution {
public:
    int closestValue(TreeNode* root, double target) {
        if (!root) {
            return -1;
        }
        TreeNode* curr = root;
        int res = root->val;
        while (curr) {
            if (curr->val == target) {
                return curr->val;
            }
            if (abs(curr->val - target) < abs(res - target)) {
                res = curr->val;
            }
            curr = target < curr->val ? curr->left : curr->right;
        }
        return res;
    }
};
