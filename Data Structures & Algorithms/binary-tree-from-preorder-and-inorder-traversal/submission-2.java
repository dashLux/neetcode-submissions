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
    int index = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>(); //inorder[i] -> i
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = dfs(preorder, 0 /* inorder[0]*/, inorder.length - 1);
        return root;
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode currRoot = new TreeNode(preorder[index]);
        index++;
        //get index of current root from inorder[]
        int mid = inorderMap.get(currRoot.val);
        currRoot.left = dfs(preorder, left, mid - 1);
        currRoot.right = dfs(preorder, mid+1, right);
        return currRoot;
    }
}
