/************************************************************
 * 
 * Following is the Tree node structure
 * 
 * class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * 
 * TreeNode(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * }
 * 
 ************************************************************/

public class maximumPathSum {
    public static long maxsum = 0;
    public static int countLeaf = 0;

    public static long findMaxSumPath(TreeNode root) {
        // Write your code here.
        if (root == null)
            return -1;
        maxsum = 0;
        countLeaf = 0;
        findMax(root);
        if (countLeaf < 2)
            return -1;
        return maxsum;
    }

    private static long findMax(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            countLeaf++;
        long left = findMax(root.left);
        long right = findMax(root.right);
        maxsum = Math.max(maxsum, (left + right + root.data));
        return root.data + Math.max(left, right);
    }
}