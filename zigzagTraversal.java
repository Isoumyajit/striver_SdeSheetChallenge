import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class zigzagTraversal {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here!

        List<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<BinaryTreeNode<Integer>> helper = new LinkedList<>();
        helper.offer(root);
        boolean flag = false;
        while (!helper.isEmpty()) {
            int size = helper.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size > 0) {
                BinaryTreeNode node = helper.poll();
                temp.add((Integer) node.data);
                if (node.left != null)
                    helper.offer(node.left);
                if (node.right != null)
                    helper.offer(node.right);
                size--;
            }
            if (flag) {
                Collections.reverse(temp);
                flag = false;
            } else
                flag = true;
            while (temp.size() > 0) {
                answer.add(temp.get(0));
                temp.remove(0);
            }
        }
        return answer;
    }
}
