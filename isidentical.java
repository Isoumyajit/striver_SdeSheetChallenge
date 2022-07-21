import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class isidentical {

    public static boolean identicalTrees(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        // Write you code here.

        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;

        return ((node1.data.equals(node2.data)) && identicalTrees(node1.left, node2.left)
                && identicalTrees(node1.right, node2.right));

    }

}