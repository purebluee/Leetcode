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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        stack.push(root);
        
        int i = postorder.length-2, j = inorder.length-1;
        
        while (i >= 0){
            TreeNode curr = stack.peek();
            if (curr.val != inorder[j]){
                //as long as we haven't reached the rightmost node, we can 
                //safely follow right path and attach right child
                TreeNode right = new TreeNode(postorder[i]);
                curr.right = right;
                stack.push(right);
                i--;
            }else{
                //find the node from stack where we haven't visited its left subtree
                while (!stack.isEmpty() && stack.peek().val == inorder[j]){
                    curr = stack.pop();
                    j--;
                }
                
                TreeNode left = new TreeNode(postorder[i]);
                curr.left = left;
                stack.push(left);
                i--;
            }
            
        }
        return root;
    }
}