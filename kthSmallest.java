import java.util.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
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

public class kthSmallest {

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        // Write your code here.
        if (root == null)
            return -1;
        ArrayList<Integer> helper = new ArrayList<>();
        getInorder(root, helper);
        if (helper.size() < k)
            return -1;
        return helper.get(k - 1);
    }

    private static void getInorder(TreeNode<Integer> root, ArrayList<Integer> helper) {
        if (root == null)
            return;
        getInorder(root.left, helper);
        helper.add(root.data);
        getInorder(root.right, helper);
    }

}
