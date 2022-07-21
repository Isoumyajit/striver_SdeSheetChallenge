import java.util.*;

class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data) {
        this.val = data;
        left = null;
        right = null;
    }
}

public class buildTreefromSortedArray {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        TreeNode<Integer> root = createTree(arr, n - 1, 0);
        return root;
    }

    private static TreeNode<Integer> createTree(ArrayList<Integer> arr, int high, int low) {

        if (low < 0 || high > arr.size() || low > high)
            return null;

        int mid = low + (high - low) / 2;
        // System.out.println(arr.get(mid));
        TreeNode<Integer> root = new TreeNode(arr.get(mid));
        root.left = createTree(arr, mid - 1, low);
        root.right = createTree(arr, high, mid + 1);
        return root;
    }
}