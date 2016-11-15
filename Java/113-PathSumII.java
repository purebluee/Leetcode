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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findPathSum(root, res, currPath, sum);
        return res;
    }
    private void findPathSum(TreeNode root, List<List<Integer>> res, List<Integer> currPath, int sum){
        if (root == null){
            return;
        }
        currPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList(currPath));
        }else{
            findPathSum(root.left, res, currPath, sum-root.val);
            findPathSum(root.right, res, currPath, sum-root.val);
        }
        currPath.remove(currPath.size()-1);
    }
}