/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode<T>
 * {
 * public:
 * T data;
 * TreeNode<T> left;
 * TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * };
 * 
 ************************************************************/

public class floorinABST {
    public static int floorVal = -1;

    public static int floorInBST(TreeNode<Integer> root, int X) {
        // Write your code here.
        floorVal = -1;
        findFloor(root, X);
        return floorVal;

    }

    private static void findFloor(TreeNode<Integer> root, int x) {

        if (root == null)
            return;

        if (root.data <= x)
            floorVal = root.data;
        if (root.data > x) {
            findFloor(root.left, x);
        } else
            findFloor(root.right, x);
    }
}