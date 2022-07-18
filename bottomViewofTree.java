import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pairs {
    int index;
    BinaryTreeNode node;

    Pairs(int data, BinaryTreeNode node) {
        this.index = data;
        this.node = node;
    }
}

public class bottomViewofTree {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<Pairs> helper = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper.add(new Pairs(0, root));
        while (!helper.isEmpty()) {
            Pairs newpair = helper.poll();
            if (map.containsKey(newpair.index)) {
                ArrayList<Integer> dm = map.get(newpair.index);
                dm.add(newpair.node.val);
            } else {
                ArrayList<Integer> dm = new ArrayList<>();
                dm.add(newpair.node.val);
                map.put(newpair.index, dm);
            }
            if (newpair.node.left != null) {
                helper.add(new Pairs(newpair.index - 1, newpair.node.left));
            }
            if (newpair.node.right != null) {
                helper.add(new Pairs(newpair.index + 1, newpair.node.right));
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> hm : map.entrySet()) {
            answer.add(hm.getValue().get(hm.getValue().size() - 1));
        }
        return answer;
    }
}
