import java.util.*;

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> next;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }
}

public class connectNodesasSamelevel {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> helper = new LinkedList<>();
        helper.offer(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            BinaryTreeNode<Integer> prev = helper.peek();
            while (size > 0) {
                BinaryTreeNode<Integer> temp = helper.poll();
                if (temp != prev && helper.size() >= 0) {
                    prev.next = temp;
                    prev = temp;
                }
                if (temp.left != null)
                    helper.offer(temp.left);
                if (temp.right != null)
                    helper.offer(temp.right);
                size--;
            }
            prev.next = null;
        }
    }

}