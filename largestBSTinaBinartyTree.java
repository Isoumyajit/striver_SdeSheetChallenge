
public class largestBSTinaBinartyTree {
    public static int largestBST(TreeNode<Integer> root) {
        PairValue answer = getMaxSize(root);
        return answer.size;
    }

    private static PairValue getMaxSize(TreeNode<Integer> root) {
        if (root == null)
            return new PairValue(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        PairValue left = getMaxSize(root.left);
        PairValue right = getMaxSize(root.right);
        PairValue ans = null;
        if (root.data > left.max && root.data < right.min) {
            ans = new PairValue(1 + left.size + right.size, Math.max(root.data, right.max),
                    Math.min(root.data, left.min));
        } else
            ans = new PairValue(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);

        return ans;
    }
}

class PairValue {
    int min;
    int max;
    int size;

    PairValue(int size, int max, int min) {
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
