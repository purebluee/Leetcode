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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        
    }
}

//Iterative:
//BFS:
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int count = 0;
    while(!queue.isEmpty()) {
        int size = queue.size();
        while(size-- > 0) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        count++;
    }
    return count;
}
//DFS:
public int maxDepth(TreeNode root) {
    Stack<TreeNode> nodes = new Stack<TreeNode>();
    Stack<Integer> depths= new Stack<Integer>();
    nodes.push(root);
    depths.push(1);
    int max = 0;
    
    while(!nodes.isEmpty()) {
        TreeNode node = nodes.pop();
        int depth = depths.pop();
        if (node == null) continue;
        if (depth > max) max = depth;
        nodes.push(node.left);
        depths.push(depth+1);
        nodes.push(node.right);
        depths.push(depth+1);
    }
    
    return max;
}