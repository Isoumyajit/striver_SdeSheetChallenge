import java.util.ArrayList;
import java.util.List;

public class dfs {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        List<Integer>[] adjlist = new List[v];
        for (int i = 0; i < v; i++) {
            adjlist[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[v];
        for (int index = 0; index < edges.size(); index++) {
            int a = edges.get(index).get(0);
            int b = edges.get(index).get(1);
            adjlist[a].add(b);
            adjlist[b].add(a);
        }

        ArrayList<ArrayList<Integer>> dfsanswer = new ArrayList<>();
        for (int index = 0; index < v; index++) {
            ArrayList<Integer> answer = new ArrayList<>();
            if (!visited[index]) {
                dfs_traversal(visited, adjlist, index, answer);
                dfsanswer.add(new ArrayList<>(answer));
            }
        }
        return dfsanswer;
    }

    private static void dfs_traversal(boolean[] visited, List<Integer>[] lst, int currentnode,
            ArrayList<Integer> answer) {
        if (visited[currentnode])
            return;
        visited[currentnode] = true;
        answer.add(currentnode);
        for (int node : lst[currentnode]) {
            dfs_traversal(visited, lst, node, answer);
        }
    }
}