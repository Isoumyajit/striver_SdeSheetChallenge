import java.util.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure
 * 
 * class BinaryTreeNode<Integer> {
 * int data;
 * BinaryTreeNode<Integer> left;
 * BinaryTreeNode<Integer> right;
 * 
 * public BinaryTreeNode(int data) {
 * this.data = data;
 * }
 * }
 * 
 *************************************************************/

public class partitalBST {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null)
            return true;
        ArrayList<Integer> helper = new ArrayList<>();
        getInorder(root, helper);
        for (int index = 1; index < helper.size(); index++)
            if (helper.get(index) < helper.get(index - 1))
                return false;

        return true;
    }

    private static void getInorder(BinaryTreeNode<Integer> root, ArrayList<Integer> helper) {

        if (root == null)
            return;
        getInorder(root.left, helper);
        helper.add(root.data);
        getInorder(root.right, helper);
    }
}
