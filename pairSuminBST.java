
import java.util.*;

class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class pairSuminBST {
    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        if (root == null)
            return false;
        Set<Integer> helper = new HashSet<>();
        return getInorder(root, helper, k);
    }

    private static boolean getInorder(BinaryTreeNode root, Set<Integer> helper, int k) {

        if (root == null)
            return false;

        if (getInorder(root.left, helper, k))
            return true;
        helper.add(root.data);
        if (helper.size() > 0 && helper.contains(k - root.data))
            return true;
        return getInorder(root.right, helper, k);
    }
}
