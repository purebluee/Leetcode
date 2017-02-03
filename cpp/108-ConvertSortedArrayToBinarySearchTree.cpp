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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return help(nums, 0, nums.size()-1);
    }

    TreeNode* help(vector<int> &nums, int start, int end){
        if(end-start < 0)
            return NULL;
        if(end-start == 0)
            return new TreeNode(nums[start]);
        int mid=(start + end) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = help(nums, start, mid - 1);
        root->right = help(nums, mid + 1, end);
        return root;
    }
};
