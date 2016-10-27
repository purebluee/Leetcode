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

//Iterative
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
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLevel = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if (currLevel % 2 == 0){
                    tmp.add(curr.val);
                }else{
                    tmp.add(0, curr.val);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            currLevel++;
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}