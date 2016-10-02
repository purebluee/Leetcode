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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }
    
    void traverse(TreeNode curr, List<List<Integer>> res, int level){
        if (curr == null)   return;
        if (res.size() <= level){
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }
        
        List<Integer> collection = res.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else    collection.add(0, curr.val);
        
        traverse(curr.left, res, level+1);
        traverse(curr.right, res, level+1);
    }
}