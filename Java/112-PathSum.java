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
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                sum -= root.val;
                root = root.left;
            }
            
            if(sum == 0 && stack.peek().left == null && stack.peek().right == null){
                return true;
            }
            
            //root == null
		    //pop all nodes whose children pathes have been both checked.
            while (!stack.isEmpty() && stack.peek().right == root){
                root = stack.pop();
                sum += root.val;
            }
            
            root = stack.isEmpty() ? null : stack.peek().right;
        }
        return false;
    }
}