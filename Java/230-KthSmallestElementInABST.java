/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//In order traverse for BST gives the natural order of numbers. No need to use array.
public class Solution{
    int count = 0;
    int res = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        if (count < k)
            traverse(root, k);
        return res;
    }
    
    public void traverse(TreeNode root, int k){
        if (root == null)   return;
        traverse(root.left, k);
        count ++;
        if (count == k)  res = root.val;
        traverse(root.right, k);
    }
}
