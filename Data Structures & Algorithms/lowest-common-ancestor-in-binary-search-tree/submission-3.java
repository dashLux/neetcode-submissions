/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//both less than root.val -> search within root.left
//both greater than root.val -> search within root.right
//one less, one greater -> root is the LCA
//either one is root, root is the LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if ((p.val > root.val && q.val < root.val) ||(p.val < root.val && q.val > root.val)) {
            return root;
        }

        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        return root;
    }
}
