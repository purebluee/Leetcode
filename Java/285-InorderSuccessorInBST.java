/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 An O(h) Solution:
Since the given p node is a node in the BST (not just a value), we can directly start from the node.  There are two cases to consider:
1. If the p.right != null. Then the successor of p must be the minimum number of the right subtree.
2. If the p.right == null, then the successor of p must be the minimum number which is greater than p's value. We could start from root, if the value of the root is greater than the p.val. Then we go to the left subtree because we wanna try a smaller one. However we need to save this node because it is possible that the root.left would be smaller than the p.val. If the root's val is less than the p.val, then we simply go to the right subtree. 
 */
 
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return root;
        }
        if (p.right != null) {
            return findMin(p.right);
        }
        TreeNode curr = null, upper = root;
        while (upper != null) {
            if (p.val < upper.val) {
                curr = upper;
                upper = upper.left;
            } else if (p.val > upper.val) {
                upper = upper.right;
            } else {
                break;
            }
        }
        return curr;
    }
    
    private TreeNode findMin(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}