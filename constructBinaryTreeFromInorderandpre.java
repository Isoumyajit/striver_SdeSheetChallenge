
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

public class constructBinaryTreeFromInorderandpre {
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        // Write your code here.
        // Write your code here.
        if (inorder.size() != preorder.size())
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < inorder.size(); index++)
            map.put(inorder.get(index), index);
        TreeNode<Integer> root = null;
        root = buildTree(map, 0, preorder.size() - 1, 0, inorder.size() - 1, inorder, preorder);
        return root;
    }

    private static TreeNode<Integer> buildTree(Map<Integer, Integer> map, int prestart, int preend, int instart,
            int inend, ArrayList<Integer> inorder, ArrayList<Integer> preorder) {

        if (prestart > preend || instart > inend) {
            return null;
        }
        int nodeindex = map.get(preorder.get(prestart));
        int leftsidenodes = nodeindex - instart;
        TreeNode<Integer> root = new TreeNode(preorder.get(prestart));
        root.left = buildTree(map, prestart + 1, preend + leftsidenodes, instart, nodeindex - 1, inorder, preorder);
        root.right = buildTree(map, prestart + leftsidenodes + 1, preend, nodeindex + 1, inend, inorder, preorder);
        return root;
    }
}