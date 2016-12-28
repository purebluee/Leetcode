/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
         
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
         
        TreeLinkNode p = root;
         
        while (p.next != null && p.next.left == null && p.next.right == null) {
            p = p.next;
        }
         
         
        if (root.right != null && p.next != null) {
            if (p.next.left != null) {
                root.right.next = p.next.left;
            } else if (p.next.right != null){
                root.right.next = p.next.right;
            }
        } else if (root.left != null && p.next != null) {
            if (p.next.left != null) {
                root.left.next = p.next.left;
            } else if (p.next.right != null) {
                root.left.next = p.next.right;
            }
        }
         
        connect(root.right);
        connect(root.left);
    }
}