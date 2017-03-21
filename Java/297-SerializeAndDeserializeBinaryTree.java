/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
         
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
         
        StringBuffer sb = new StringBuffer();
         
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val + ",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                sb.append("#" + ",");
            }
        }
         
        // Remove the trailing #
        String result = sb.toString();
        int j = result.length() - 1;
         
        while (j > 0 && result.charAt(j) == ',' && result.charAt(j) == '#') {
            j -= 2;
        }
         
        result = result.substring(0, j);
        return sb.toString();
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
         
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
         
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
 
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (nodes[i].equals("#")) {
                curr.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = leftNode;
                queue.offer(leftNode);
            }
             
            i++;
            if (i >= nodes.length) {
                break;
            }
             
            // right node
            if (nodes[i].equals("#")) {
                curr.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = rightNode;
                queue.offer(rightNode);
            }
             
            i++;
        }
         
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//another one
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        String res = "";
        LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
        parents.add(root);
        boolean end = false;
        while (!end) {
            end = true;
            int size = parents.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = parents.removeFirst();
                String s = temp == null? "#": temp.val + "";
                res = res.length() == 0? res + s: res + "," + s;
                if (temp != null) {
                    if (!isLeaf(temp))
                        end = false;
                    parents.add(temp.left);
                    parents.add(temp.right);
                }
            }
        }
        return res;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        if (data.length() == 0)
            return null;
        if (data.equals("#"))
            return null;
        String[] strs = data.split(",");
        int len = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
        parents.add(root);
        int i = 1;
        while (i < len) {
            int size = parents.size();
            for (int j = 0; j < size; j++) {
                TreeNode temp = parents.removeFirst();
                temp.left = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                temp.right = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                if (temp.left != null)
                    parents.add(temp.left);
                if (temp.right != null)
                    parents.add(temp.right);
            }
        }
        return root;
    }
}