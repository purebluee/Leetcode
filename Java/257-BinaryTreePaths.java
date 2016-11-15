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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)   return result;
        String s = root.val + "";
        getPaths(result, root, s);
        return result;
    }
    
    public void getPaths(List<String> result, TreeNode root, String s){
        if (root.left == null && root.right == null){
            result.add(s);
            return;
        }
        if(root.left != null){
            getPaths(result, root.left, s + "->" + root.left.val);
        }
        if (root.right != null){
            getPaths(result, root.right, s + "->" + root.right.val);
        }
        
    }
}