
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class isheightBalanced {

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return true;
        return isbalanced(root);
    }

    private static boolean isbalanced(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(right - left) > 1)
            return false;
        else
            return isbalanced(root.left) & isbalanced(root.right);
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
