import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.ACTIVITY_COMPLETED;

public class bellManford {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        int[] cost = new int[n];
        cost[src] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int relax = 1; relax <= n - 1; relax++) {
            for (int ed = 0; ed < edges.size(); ed++) {
                if (cost[edges.get(ed).get(0)] + edges.get(ed).get(2) < cost[edges.get(ed).get(0)]) {
                    cost[edges.get(ed).get(0)] = cost[edges.get(ed).get(0)] + edges.get(ed).get(2);
                }
            }
        }
        return cost[dest];
    }

}

class Node {

    int data;
    int weight;

    Node(int data, int weight) {
        this.data = data;
        this.data = weight;
    }
}
