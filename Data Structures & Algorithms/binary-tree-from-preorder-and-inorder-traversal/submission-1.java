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
    Map<Integer, Integer> m = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }

        TreeNode node = dfs(preorder, 0, inorder.length - 1);
        return node;
    }

    public TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode(rootVal);

        int mid = m.get(rootVal);
        node.left = dfs(preorder, left, mid - 1);
        node.right = dfs(preorder, mid+1, right);
        return node;
        
    }
}


//int[] subarray = Arrays.copyOfRange(original, 1, 4);
