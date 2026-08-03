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

    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialize(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] i = {0};
        return dfsDeserialize(nodes, i);
        
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(String.valueOf(root.val)+ ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode dfsDeserialize(String[] nodes, int[] i) {
        if (nodes[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(nodes, i);
        node.right = dfsDeserialize(nodes, i);
        return node;
    }
}
