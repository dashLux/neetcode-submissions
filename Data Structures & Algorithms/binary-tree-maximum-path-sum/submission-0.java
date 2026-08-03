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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int getMaxDownPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMaxDownPath = getMaxDownPath(node.left);
        int rightMaxDownPath = getMaxDownPath(node.right);

        int currPathSum = node.val + Math.max(leftMaxDownPath, rightMaxDownPath);
        return Math.max(0, currPathSum);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        int left = getMaxDownPath(node.left);
        int right = getMaxDownPath(node.right);

        res = Math.max(res, left + right + node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
