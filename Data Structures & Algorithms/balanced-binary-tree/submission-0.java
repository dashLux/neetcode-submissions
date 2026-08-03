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
    public boolean isBalanced(TreeNode root) {
        int[] res = dfs(root);
        return res[0] == 1;
    }

    //return: int[2] --> 0: 1/0 denoting if tree is balanced
    //                   1: height of tree
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] leftResult = dfs(root.left);
        int[] rightResult = dfs(root.right);

        boolean balanced = leftResult[0] == 1 && rightResult[0] == 1
                       && Math.abs(leftResult[1] - rightResult[1]) <= 1;
        
        int height = Math.max(leftResult[1], rightResult[1]);
        if (balanced) {
            return new int[]{1, 1+height};
        }

        return new int[]{0, 1+height};
    }
}
