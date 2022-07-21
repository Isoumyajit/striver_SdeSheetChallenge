
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class boundaryOrder {
    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        answer.add(root.data);
        if (root.left == null && root.right == null)
            return answer;
        findLeftboundary(answer, root.left);
        // System.out.println(answer);
        findLeaf(answer, root);
        // System.out.println(answer);
        Stack<Integer> helper = new Stack<>();

        findRightboundary(helper, root.right);
        // System.out.println(helper);
        while (!helper.isEmpty()) {
            answer.add(helper.pop());
        }
        return answer;
    }

    private static void findLeftboundary(ArrayList<Integer> answer, TreeNode root) {

        if (root == null)
            return;
        if (root.left != null) {
            answer.add(root.data);
            findLeftboundary(answer, root.left);
            return;
        } else if (root.right != null) {
            answer.add(root.data);
            findLeftboundary(answer, root.right);
        }
    }

    private static void findLeaf(ArrayList<Integer> answer, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            answer.add(root.data);
            return;
        }
        findLeaf(answer, root.left);
        findLeaf(answer, root.right);
    }

    private static void findRightboundary(Stack<Integer> answer, TreeNode root) {
        if (root == null)
            return;
        if (root.right != null) {
            answer.push(root.data);
            findRightboundary(answer, root.right);
            return;
        } else if (root.left != null) {
            answer.push(root.data);
            findRightboundary(answer, root.left);
        }
    }
}