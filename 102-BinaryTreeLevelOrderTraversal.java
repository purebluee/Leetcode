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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        addNode(result, root, 0);
        return result;
    }
    
    public void addNode(List<List<Integer>> result, TreeNode node, int level){
        if (node == null)
            return;
        if (result.size() <= level){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            result.add(tmp);
        }else{
            result.get(level).add(node.val);
        }
        addNode(result, node.left, level+1);
        addNode(result, node.right, level+1);
    }
}