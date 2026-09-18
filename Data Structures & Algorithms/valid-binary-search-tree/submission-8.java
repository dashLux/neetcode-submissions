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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTInternal(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValidBSTInternal(TreeNode root, int upper, int lower) {
        if (root == null) {
            return true;
        }

        if (root.val >= upper || root.val <= lower) {
            return false;
        }

        return (isValidBSTInternal(root.left, root.val, lower) && isValidBSTInternal(root.right, upper, root.val));
    }
}
