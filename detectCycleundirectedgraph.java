import java.util.*;

public class detectCycleundirectedgraph {

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] lst = new List[n + 1];
        for (int index = 0; index <= n; index++) {
            lst[index] = new ArrayList<>();
        }
        for (int index = 0; index < edges.length; index++) {
            lst[edges[index][0]].add(edges[index][1]);
            lst[edges[index][1]].add(edges[index][0]);
        }
        for (int index = 1; index <= n; index++) {
            if (!visited[index])
                if (dfs(lst, visited, index, -1))
                    return "Yes";
        }
        return "No";
    }

    private static boolean dfs(List<Integer>[] lst, boolean[] visited, int node, int prev) {

        visited[node] = true;
        for (int nodes : lst[node]) {
            if (!visited[nodes]) {
                if (dfs(lst, visited, nodes, node))
                    return true;
            } else if (nodes != prev)
                return true;

        }
        return false;
    }
}