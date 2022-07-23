import java.util.*;

public class binaryTreetoDLL {

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        // Write your crode here
        if (root == null)
            return null;
        BinaryTreeNode<Integer> head = null;
        BinaryTreeNode<Integer> node = null;
        ArrayList<BinaryTreeNode<Integer>> helper = new ArrayList<>();
        dll(root, helper);
        for (int index = 0; index < helper.size(); index++) {
            if (index == 0) {
                head = helper.get(index);
                node = head;
            } else if (index == helper.size() - 1) {
                BinaryTreeNode<Integer> lstnode = helper.get(index);
                lstnode.right = null;
                lstnode.left = node;
                node.right = lstnode;
            } else {
                BinaryTreeNode<Integer> newnode = helper.get(index);
                newnode.left = node;
                node.right = newnode;
                node = newnode;
            }
        }
        return head;
    }

    private static void dll(BinaryTreeNode<Integer> root, ArrayList<BinaryTreeNode<Integer>> helper) {

        if (root == null)
            return;
        dll(root.left, helper);
        helper.add(root);
        dll(root.right, helper);
    }
}
