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
        int[] res = dfs(root);
        return res[0] == 1;
        
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] isLeftBalanced = dfs(root.left);
        int[] isRightBalanced = dfs(root.right);
        int height = Math.max(isLeftBalanced[1], isRightBalanced[1]);

        boolean isCurrBalanced = 
        (isLeftBalanced[0] == 1 && isRightBalanced[0] == 1) && (Math.abs(isLeftBalanced[1] - isRightBalanced[1]) <= 1);

        return new int[]{isCurrBalanced ? 1 : 0, 1 + height};
    }
}
