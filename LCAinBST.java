/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class LCAinBST {

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // Write your code here
        if (root == null)
            return null;
        if (root.data > p.data && root.data > q.data)
            return LCAinaBST(root.left, p, q);
        else if (root.data < q.data && root.data < p.data)
            return LCAinaBST(root.right, p, q);

        return root;
    }
}