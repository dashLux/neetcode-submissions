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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
        
    }
    
    private void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(String.valueOf(root.val) + ",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(",");
        int[] index = {0};
        return dfsDeserialize(nodes, index);
        
    }

    private TreeNode dfsDeserialize(String[] nodes, int[] index) {
        if (nodes[index[0]].equals("N")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = dfsDeserialize(nodes, index);
        node.right = dfsDeserialize(nodes, index);
        return node;
    }
}
