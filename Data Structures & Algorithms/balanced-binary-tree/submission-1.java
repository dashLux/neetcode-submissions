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

    //int[2] res -> res[0] = 0/1 denoting if tree with root is balanced
    //              res[1] = height of current tree
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] isLeftBalanced = dfs(root.left);
        int[] isRightBalanced = dfs(root.right);

        boolean balanced = isLeftBalanced[0] == 1
                            && isRightBalanced[0] == 1
                            && (Math.abs(isLeftBalanced[1] - isRightBalanced[1]) <= 1);
        
        int height = Math.max(isLeftBalanced[1], isRightBalanced[1]);
        return new int[]{balanced ? 1 : 0, 1 + height};
    }
}
