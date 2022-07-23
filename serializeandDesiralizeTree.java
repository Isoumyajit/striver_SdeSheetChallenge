import java.util.*;

public class serializeandDesiralizeTree {
    public static String serializeTree(TreeNode<Integer> root) {
        // Write your code here for serialization of the tree.
        // Write your code here for serialization of the tree.
        if (root == null)
            return "";
        StringBuffer serialized = new StringBuffer();
        Queue<TreeNode> helper = new LinkedList<>();
        helper.offer(root);
        while (!helper.isEmpty()) {
            TreeNode node = helper.poll();
            if (node == null) {
                serialized.append("# ");
                continue;
            }
            serialized.append(node.data + " ");
            helper.offer(node.left);
            helper.offer(node.right);
        }
        // System.out.println(serialized);

        return serialized.toString();
    }

    public static TreeNode deserializeTree(String str) {
        // Write your code here for deserialization of the tree.
        if (str.equals(""))
            return null;

        Queue<TreeNode> helper = new LinkedList<>();
        String[] nodes = str.split(" ");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        helper.offer(root);
        while (!helper.isEmpty()) {
            TreeNode currentParent = helper.poll();
            if (!nodes[i].equals("#")) {
                TreeNode leftnode = new TreeNode(Integer.parseInt(nodes[i++]));
                currentParent.left = leftnode;
                helper.offer(leftnode);
            } else {
                currentParent.left = null;
                i++;
            }
            if (!nodes[i].equals("#")) {
                TreeNode rightnode = new TreeNode(Integer.parseInt(nodes[i++]));
                currentParent.right = rightnode;
                helper.offer(rightnode);
            } else {
                currentParent.right = null;
                i++;
            }
        }

        return root;
    }
}