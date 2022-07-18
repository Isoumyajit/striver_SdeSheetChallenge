import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

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

class Pairs {
    int index;
    TreeNode<Integer> nodevalue;

    Pairs(int index, TreeNode<Integer> node) {
        this.index = index;
        this.nodevalue = node;
    }
}

public class verticalOrderTraversal {
    public static ArrayList<Integer> verticalOrderTraversa(TreeNode<Integer> root) {
        // Write your code here.
        Map<Integer, ArrayList<TreeNode<Integer>>> map = new TreeMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<Pairs> helper = new LinkedList<>();
        Pairs pair = new Pairs(0, root);
        helper.add(pair);

        while (!helper.isEmpty()) {

            int size = helper.size();
            while (size > 0) {
                Pairs newpair = helper.poll();
                if (map.containsKey(newpair.index)) {
                    ArrayList<TreeNode<Integer>> dummy = map.get(newpair.index);
                    dummy.add(newpair.nodevalue);
                } else {
                    ArrayList<TreeNode<Integer>> dummy = new ArrayList<>();
                    dummy.add(newpair.nodevalue);
                    map.put(newpair.index, dummy);
                }
                if (newpair.nodevalue.left != null) {
                    Pairs makePair = new Pairs(newpair.index - 1, newpair.nodevalue.left);
                    helper.add(makePair);
                }
                if (newpair.nodevalue.right != null) {
                    Pairs makePair = new Pairs(newpair.index + 1, newpair.nodevalue.right);
                    helper.add(makePair);
                }
                size--;
            }
        }
        for (Entry<Integer, ArrayList<TreeNode<Integer>>> dummy : map.entrySet()) {
            for (TreeNode<Integer> nodes : dummy.getValue()) {
                answer.add((Integer) nodes.data);
            }
        }
        return answer;
    }
}
