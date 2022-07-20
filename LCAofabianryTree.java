
class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LCAofabianryTree {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        // Write your code here.
        if (root == null)
            return -1;
        if (root.data == x || root.data == y) {
            return root.data;
        }
        int a = lowestCommonAncestor(root.left, x, y);
        int b = lowestCommonAncestor(root.right, x, y);
        if (a == -1)
            return b;
        if (b == -1)
            return a;
        return root.data;

    }
}
