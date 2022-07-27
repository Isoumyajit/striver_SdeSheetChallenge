import java.util.*;

public class stronglyConnectedComponent {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here

        List<Integer>[] lst = new List[n];
        for (int index = 0; index < n; index++)
            lst[index] = new ArrayList<>();

        for (int index = 0; index < edges.length; index++) {
            lst[edges[index][0]].add(edges[index][1]);
        }
        Stack<Integer> helper = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int index = 0; index < n; index++) {
            if (!visited[index])
                dfs(helper, lst, index, visited);
        }

        List<Integer>[] transpose = new List[n];
        for (int index = 0; index < n; index++)
            transpose[index] = new ArrayList<>();
        for (int index = 0; index < edges.length; index++) {
            transpose[edges[index][1]].add(edges[index][0]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.fill(visited, false);
        ArrayList<Integer> answer = new ArrayList<>();
        while (!helper.isEmpty()) {
            int node = helper.pop();
            if (!visited[node]) {
                revdfs(answer, node, transpose, visited);
                ans.add(new ArrayList<>(answer));
                answer.clear();
            }
        }
        return ans;
    }

    private static void dfs(Stack<Integer> helper, List<Integer>[] lst, int node, boolean[] visited) {

        visited[node] = true;
        for (int nodes : lst[node]) {
            if (!visited[nodes])
                dfs(helper, lst, nodes, visited);
        }
        helper.push(node);
    }

    private static void revdfs(ArrayList<Integer> helper, int node, List<Integer>[] lst, boolean[] visited) {

        visited[node] = true;
        helper.add(node);
        for (int nodes : lst[node]) {
            if (!visited[nodes])
                revdfs(helper, nodes, lst, visited);
        }
    }
}