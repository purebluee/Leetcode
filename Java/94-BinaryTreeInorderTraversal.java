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
    //Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
    private List<Integer> helper(TreeNode root, List<Integer> res){
        if (root == null){
            return res;
        }
        if (root.left != null){
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null){
            helper(root.right, res);
        }
        return res;
    }
    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null)   return l;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            l.add(curr.val);
            curr = curr.right;
        }
        return l;
    }
}