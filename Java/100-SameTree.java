/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Pay attention to null pointers!
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}

//iterative solution
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
         Stack<TreeNode> stack1 = new Stack<>();       
         Stack<TreeNode> stack2 = new Stack<>();
         if (p != null) 
            stack1.push(p);
         if (q != null) 
            stack2.push(q);
         while (!stack1.isEmpty() && !stack2.isEmpty()) {
             TreeNode pn = stack1.pop();
             TreeNode qn = stack2.pop();
             if (pn.val != qn.val) 
                return false;
             if (pn.right != null) 
                stack1.push(pn.right);
             if (qn.right != null) 
                stack2.push(qn.right);
             if (stack1.size() != stack2.size()) 
                return false;
             if (pn.left != null) 
                stack1.push(pn.left);
             if (qn.left != null) 
                stack2.push(qn.left);
             if (stack1.size() != stack2.size()) 
                return false;
         }
         return stack1.size() == stack2.size(); 
    }
}