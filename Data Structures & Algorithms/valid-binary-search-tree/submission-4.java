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
        boolean isValid = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }

    private boolean dfs(TreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }

        boolean isLeftValid = dfs(root.left, lowerBound, root.val);
        boolean isRightValid = dfs(root.right, root.val, upperBound);
        return isLeftValid && isRightValid;
    }
}
