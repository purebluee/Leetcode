/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //recursive
    //The number of recursive calls is bound by the height of the tree. 
    //In the worst case, the tree is linear and the height is in O(n)O(n)O(n). 
    //Therefore, space complexity due to recursive calls on the stack is O(n)O(n)O(n) in the worst case.
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetricCheck(root.left, root.right);
    }
    private boolean symmetricCheck(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return symmetricCheck(left.left, right.right) && symmetricCheck(left.right, right.left);
    }

    //Iterative
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null){
            return true;
        }
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 1){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if (left == null && right == null){
                continue;
            }
            if (left == null ^ right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
            
        }
        return true;
    }
}