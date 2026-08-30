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


// [boolean, int] -> [isbalanced, height]
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] result = dfs(root);
        return result[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] leftBalanced = dfs(root.left);
        int[] rightBalanced = dfs(root.right);

        boolean balanced = leftBalanced[0] == 1 && rightBalanced[0] == 1 &&
                            (Math.abs(leftBalanced[1] - rightBalanced[1]) <= 1);
        
        int height = Math.max(leftBalanced[1], rightBalanced[1]);

        return new int[]{balanced ? 1 : 0, 1 + height};
        

    }
}
