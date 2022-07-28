import java.util.*;

public class prims {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        List<Node>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < g.size(); i++) {
            Node pair1 = new Node(g.get(i).get(1), g.get(i).get(2));
            Node pair2 = new Node(g.get(i).get(0), g.get(i).get(2));
            adj[g.get(i).get(0)].add(pair1);
            adj[g.get(i).get(1)].add(pair2);
        }
        PriorityQueue<Node> helper = new PriorityQueue<>(new comparenode());
        int[] parent = new int[n + 1];
        int[] weight = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Arrays.fill(weight, Integer.MAX_VALUE);
        Node start = new Node(1, 0);
        parent[1] = -1;
        helper.offer(start);

        while (!helper.isEmpty()) {
            Node nd = helper.poll();
            visited[nd.data] = true;
            for (Node newnode : adj[nd.data]) {
                if (!visited[newnode.data] && weight[newnode.data] > newnode.weight) {
                    parent[newnode.data] = nd.data;
                    weight[newnode.data] = newnode.weight;
                    helper.offer(newnode);
                }
            }
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            ArrayList<Integer> t = new ArrayList<>();
            int node = parent[index];
            int w = weight[index];
            if (node == -1)
                continue;
            t.addAll(Arrays.asList(parent[index], index, w));
            answer.add(t);
        }
        return answer;
    }
}

class Node {
    int data;
    int weight;

    Node(int data, int weight) {
        this.data = data;
        this.weight = weight;
    }
}

class comparenode implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b) {
        return Integer.compare(a.weight, b.weight);
    }
}
