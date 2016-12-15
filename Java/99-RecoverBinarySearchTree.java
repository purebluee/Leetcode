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
 Solution:
If a binary tree is a BST, its inorder traversal should be in ascending order. We may use this property to solve this problem. Consider the following case:
For the inorder traversal list 123456, if 2 and 6 are swapped, the list becomes
163452. So when we scan the list, our goal is to mark the two swapped numbers and swap them back. So we can use two pointers, p and q. We compare the current value with the previous one, so when we see the first descending value, which is 3, the p pointer points to the previous node before 3, which is 6. When the next time we see the descending order again, which is 2, we use q pointer points to 2. Then we can swap the two numbers. 

Do we consider all the case? Actually there is still a case we did not consider. For the two numbers in adjacent, e.g. 123456, where 34 are swapped, so now it is 124356. The first time it encounters a descending order is at 3, where we point p to 4, the one before 3, then there is no other descending later. So where is q? So we should point q to this current position. 
 */
 
public class Solution {
    TreeNode p,q;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
         
        inOrderTraversal(root);
         
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
     
    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
         
        if (prev != null && root.val < prev.val) {
            if (p == null) {
                p = prev;
                q = root;
            } else {
                q = root;
            }
        }
        prev = root;
        inOrderTraversal(root.right);
    }
}