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
    int maxDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};


 //Iterative DFS
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        stack<TreeNode*> nodes;
        stack<int> depths;
        nodes.push(root);
        depths.push(1);
        int maxD = 1;

        while (!nodes.empty()){
            TreeNode* curr = nodes.top();
            nodes.pop();
            int currDepth = depths.top();
            depths.pop();
            if (curr->left){
                nodes.push(curr->left);
                depths.push(currDepth + 1);
                maxD = max(currDepth + 1, maxD);
            }
            if (curr->right){
                nodes.push(curr->right);
                depths.push(currDepth + 1);
                maxD = max(currDepth + 1, maxD);
            }
        }
        return maxD;
    }
};

//Iterative DFS using pairs:

class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        stack<pair<TreeNode*, int>> s;
        s.push({root, 1});
        int maxD = 1;
        while (!s.empty()){
            pair<TreeNode*, int> curr = s.top();
            s.pop();
            TreeNode* currNode = curr.first;
            int currDepth = curr.second;
            if (currNode->left){
                s.push({currNode->left, currDepth+1});
                maxD = max(currDepth+1, maxD);
            }
            if (currNode->right){
                s.push({currNode->right, currDepth+1});
                maxD = max(currDepth+1, maxD);
            }
        }
        return maxD;
    }
};

//Iterative BFS:
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root){
            return 0;
        }
        queue<pair<TreeNode*, int>> q;
        q.push({root, 1});
        int maxD = 0;
        while (!q.empty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                pair<TreeNode*, int> curr = q.front();
                q.pop();
                TreeNode* currN = curr.first;
                int currD = curr.second;
                if (currN->left){
                    q.push({currN->left, currD + 1});
                }
                if (currN->right){
                    q.push({currN->right, currD + 1});
                }
            }
            maxD++;
        }
        return maxD;
    }
};
