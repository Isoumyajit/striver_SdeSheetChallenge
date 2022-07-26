import java.util.ArrayList;
import java.util.List;

public class checkBipartite {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        // Write your code here
        List<Integer>[] lst = new List[edges.size()];
        int[] colors = new int[edges.size()];
        for (int index = 0; index < lst.length; index++) {
            lst[index] = new ArrayList<>();
        }
        for (int index = 0; index < edges.size(); index++) {
            for (int c = 0; c < edges.get(index).size(); c++) {
                if (edges.get(index).get(c) == 1) {
                    lst[index].add(c);
                    lst[c].add(index);
                }
            }
        }
        if (checkForBipartite(2, 0, lst, edges.size(), colors))
            return true;
        return false;

    }

    private static boolean checkForBipartite(int m, int node, List<Integer>[] lst, int n, int[] colors) {

        if (node == n)
            return true;
        for (int color = 1; color <= m; color++) {
            if (isPossible(node, color, lst, colors)) {
                colors[node] = color;
                if (checkForBipartite(m, node + 1, lst, n, colors))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private static boolean isPossible(int node, int color, List<Integer>[] lst, int colors[]) {

        for (int nodes : lst[node]) {
            if (colors[nodes] == color)
                return false;
        }

        return true;
    }
}