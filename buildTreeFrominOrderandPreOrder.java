import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class buildTreeFrominOrderandPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> helper = new HashMap<>();
        for (int index = 0; index < inorder.length; index++)
            helper.put(inorder[index], index);
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, helper);
        return root;
    }

    private static TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd,
            Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(root.val);
        int left = index - inStart;
        root.left = build(preorder, inorder, preStart + 1, preStart + left, inStart, index - 1, map);
        root.right = build(preorder, inorder, preStart + left + 1, preEnd, index + 1, inEnd, map);
        return root;

    }
}