
class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class diameterOfabinaryTree {
    static int max = 0;

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return 0;
        max = 0;
        diameter(root);
        return max;
    }

    private static int diameter(BinaryTreeNode<Integer> root) {

        if (root == null)
            return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}