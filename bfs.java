import java.util.*;

public class bfs {
    public static ArrayList<Integer> BFS(int vertex, int edges[][]) {
        // WRITE YOUR CODE HERE
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> helper = new LinkedList<>();

        List<Integer>[] nodes = new List[vertex];
        for (int index = 0; index < vertex; index++) {
            nodes[index] = new ArrayList<>();
        }
        for (int index = 0; index < edges[0].length; index++) {
            nodes[edges[0][index]].add(edges[1][index]);
            nodes[edges[1][index]].add(edges[0][index]);
        }

        for (int index = 0; index < vertex; index++) {
            Collections.sort(nodes[index]);
        }
        boolean[] visited = new boolean[vertex];
        helper.offer(0);
        while (!helper.isEmpty()) {
            int node = helper.poll();
            if (visited[node])
                continue;
            answer.add(node);
            visited[node] = true;
            for (int newnode : nodes[node]) {
                helper.offer(newnode);
            }
        }
        for (int index = 0; index < vertex; index++)
            if (!visited[index])
                answer.add(index);
        return answer;

    }
}
