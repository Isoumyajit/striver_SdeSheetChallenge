import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class krusklas {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Node> helper = new PriorityQueue<>(new comparenode());
        for (int index = 0; index < graph.size(); index++) {
            Node pair = new Node(graph.get(index).get(0), graph.get(index).get(1), graph.get(index).get(2));
            // Node pair1 = new Node(graph.get(index).get(1), graph.get(index).get(2));
            helper.offer(pair);
            // helper.offer(pair1);
        }

        int minimum_cost = 0;
        while (!helper.isEmpty()) {
            Node nd = helper.poll();
            if (!set.contains(nd.dest) && !set.contains(nd.src)) {
                minimum_cost += nd.weight;
                if (!set.contains(nd.dest))
                    set.add(nd.dest);
                if (!set.contains(nd.src))
                    set.add(nd.src);

            }
        }
        return minimum_cost;
    }
}

class comparenode implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return Integer.compare(a.weight, b.weight);
    }
}

class Node {
    int src;
    int dest;
    int weight;

    Node(int src, int dest, int weight) {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }
}