/************************************************************
 * 
 * Following is the TreeNode class structure.
 * 
 * class TreeNode<T>
 * {
 * public T data;
 * public TreeNode<T> left;
 * public TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 ************************************************************/

public class flattenAbinarytree {
    static TreeNode<Integer> prev = null;

    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        // Write your code here.
        prev = null;
        getPreorderlist(root);
        return root;
    }

    private static void getPreorderlist(TreeNode<Integer> root) {

        if (root == null)
            return;
        getPreorderlist(root.right);
        getPreorderlist(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}