import java.util.*;

public class detectCycleinDirectedGraph {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        boolean[] visited = new boolean[n + 1];
        boolean[] dfsvisited = new boolean[n + 1];
        List<Integer>[] nodes = new List[n + 1];
        for (int index = 0; index <= n; index++)
            nodes[index] = new ArrayList<>();
        for (int index = 0; index < edges.size(); index++) {
            nodes[edges.get(index).get(0)].add(edges.get(index).get(1));
        }
        for (int index = 1; index <= n; index++) {
            if (!visited[index]) {
                if (!dfsvisited[index]) {
                    // System.out.println("calling for node "+index);
                    if (dfs(nodes, index, visited, dfsvisited))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<Integer>[] nodes, int currentnode, boolean[] visited, boolean[] dfsvisited) {

        visited[currentnode] = true;
        dfsvisited[currentnode] = true;
        for (int node : nodes[currentnode]) {
            if (dfsvisited[node])
                return true;
            if (!visited[node]) {
                if (dfs(nodes, node, visited, dfsvisited))
                    return true;
            }
        }
        dfsvisited[currentnode] = false;
        return false;
    }
}