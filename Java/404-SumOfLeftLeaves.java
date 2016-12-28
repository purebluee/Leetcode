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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.left != null && node.left.left == null &&
                node.left.right == null){
                    res += node.left.val;
                }
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return res;
    }
}

//recursion
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) 
                ans += root.left.val;
            else 
                ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        
        return ans;
    }
}