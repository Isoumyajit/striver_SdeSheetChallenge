/*****************************************************************
 * 
 * Following is the representation for the Binary Tree Node:
 * 
 * class BinaryTreeNode<T> {
 * T data;
 * BinaryTreeNode<T> left;
 * BinaryTreeNode<T> right;
 * 
 * public BinaryTreeNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 ****************************************************************/
public class isSymmetric {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return true;
        return findMirror(root.left, root.right);
    }

    private static boolean findMirror(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if (root2 == null || root2 == null)
            return root1 == root2;
        return (root1.data.equals(root2.data) && findMirror(root1.left, root2.right)
                && findMirror(root1.right, root2.left));

    }
}