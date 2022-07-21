import java.util.*;

/*************************************************************
 * Following is the Binary Tree node structure
 * class TreeNode<T> {
 * public T data;
 * public TreeNode<T> left;
 * public TreeNode<T> right;
 * 
 * TreeNode(T data) {
 * this.data = data;
 * left = right = null;
 * }
 * 
 * };
 ************************************************************/
public class bstfrompreOrder {

    public static TreeNode<Integer> preOrderTree(int[] preOrder) {

        // Write your code here
        int[] inorder = preOrder.clone();
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        TreeNode<Integer> root = createTree(map, preOrder, inorder, 0, inorder.length - 1, 0, preOrder.length - 1);
        return root;
    }

    private static TreeNode<Integer> createTree(Map<Integer, Integer> map, int[] preOrder, int[] inorder, int instart,
            int inend, int prestart, int preend) {

        if (instart > inend || prestart > preend)
            return null;

        TreeNode<Integer> root = new TreeNode(preOrder[prestart]);
        int index = map.get(root.data);
        int leftnodes = index - instart;

        root.left = createTree(map, preOrder, inorder, instart, index - 1, prestart + 1, prestart + leftnodes);
        root.right = createTree(map, preOrder, inorder, index + 1, inend, prestart + leftnodes + 1, preend);
        return root;

    }

}
