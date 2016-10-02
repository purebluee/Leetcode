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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null)   return l;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()){
            if (root != null){
                l.add(root.val);
                s.push(root);
                root = root.left;
            }else{
                root = s.pop();
                root = root.right;
            }
        }
        return l;
    }

}