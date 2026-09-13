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
    int[] maxDiameter = new int[]{0};
    public int diameterOfBinaryTree(TreeNode root) {
        int rootDiameter = dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left, maxDiameter);
        int rightHeight = dfs(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
