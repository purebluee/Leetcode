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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if (i == 0){
                    res.add(curr.val);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
            }
        }
        return res;
    }
}