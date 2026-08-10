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
        boolean res = valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }

    public boolean valid(TreeNode root, int min, int high) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= high) {
            return false;
        }

        return valid(root.left, min, root.val) && valid(root.right, root.val, high);
    }
}
