//Upadated Nov 24:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Use Integer instead of int to cover Integer.MAX_VALUE and Integer.MIN_VALUE cases.
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode curr, Integer max, Integer min){
        if (curr == null){
            return true;
        }
        if ((max != null && curr.val >= max) || (min != null && curr.val <= min)){
            return false;
        }
        return isValidBST(curr.left, curr.val, min) && isValidBST(curr.right, max, curr.val);
    }
}

//Iterative:
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
         
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
         
        int prev = Integer.MIN_VALUE;
         
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode curr = stack.pop();
                if (curr.val <= prev) {
                    return false;
                }
                 
                prev = curr.val;
                 
                p = curr.right;
            }
        }
         
        return true;
    }
}


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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if ( pre != null && pre.val >= root.val)
            return false;
        pre = root;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}