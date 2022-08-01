import java.util.*;

public class topologicalSort {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Write your code here
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];
        List<Integer>[] nodes = new List[v + 1];
        for (int index = 0; index <= v; index++) {
            nodes[index] = new ArrayList<>();
        }

        for (int index = 0; index < edges.size(); index++) {

            nodes[edges.get(index).get(0)].add(edges.get(index).get(1));
        }

        Stack<Integer> helper = new Stack<>();
        for (int index = 0; index < v; index++) {
            if (!visited[index]) {
                dfs(nodes, index, visited, helper);
            }
        }
        // System.out.println(helper);
        while (!helper.isEmpty())
            answer.add(helper.pop());

        // System.out.println(answer);
        return answer;

    }

    private static void dfs(List<Integer>[] lst, int node, boolean[] visited, Stack<Integer> helperstack) {
        visited[node] = true;
        for (int n : lst[node]) {
            if (!visited[n]) {
                dfs(lst, n, visited, helperstack);
            }
        }
        helperstack.push(node);
    }
}
