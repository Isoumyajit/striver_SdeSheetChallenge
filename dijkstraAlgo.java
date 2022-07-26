import java.util.*;

public class dijkstraAlgo {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        ArrayList<Integer> answer = new ArrayList<>();
        List<Node>[] nodes = new List[vertices];
        int[] arr = new int[vertices];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int n = 0; n < vertices; n++) {
            nodes[n] = new ArrayList<>();
        }
        for (int n = 0; n < vec.size(); n++) {
            Node pair1 = new Node(vec.get(n).get(1), vec.get(n).get(2));
            Node pair2 = new Node(vec.get(n).get(0), vec.get(n).get(2));
            nodes[vec.get(n).get(1)].add(pair2);
            nodes[vec.get(n).get(0)].add(pair1);
        }
        PriorityQueue<Node> helper = new PriorityQueue<>(new nodecomparator());
        Node newnode = new Node(source, 0);
        helper.offer(newnode);
        arr[source] = 0;
        implementAlgo(helper, nodes, arr);
        for (int index = 0; index < vertices; index++) {
            answer.add(arr[index]);
        }
        return answer;
    }

    private static void implementAlgo(PriorityQueue<Node> helper, List<Node>[] nodes, int[] answer) {
        while (!helper.isEmpty()) {
            Node pair = helper.poll();
            for (Node node : nodes[pair.data]) {
                if (answer[node.data] > answer[pair.data] + node.weight) {
                    answer[node.data] = answer[pair.data] + node.weight;
                    helper.offer(node);
                    // System.out.println(helper.peek().weight);
                }
            }
        }
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

class nodecomparator implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b) {
        if (a.weight < b.weight)
            return -1;
        return 1;
    }
}