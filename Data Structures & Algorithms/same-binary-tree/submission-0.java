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
    boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return same;
    }

    public void dfs(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            same = false;
            return;
        }

        if (q != null && p != null && q.val != p.val) {
            same = false;
            return;
        }

        if (q == null && p == null) {
            return;
        }

        dfs(p.left, q.left);
        dfs(p.right, q.right);

    }
}
