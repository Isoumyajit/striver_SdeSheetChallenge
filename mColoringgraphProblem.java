import java.util.ArrayList;
import java.util.List;

public class mColoringgraphProblem {
    public static String graphColoring(int[][] mat, int m) {
        // Write your code here
        int n = mat.length;
        List<Integer>[] adj = new List[n];
        for (int index = 0; index < n; index++) {
            adj[index] = new ArrayList<Integer>();
        }
        for (int index = 0; index < n; index++) {
            for (int col = 0; col < n; col++) {
                if (mat[index][col] == 1) {
                    adj[index].add(col);
                }
            }
        }
        int[] colors = new int[n];
        if (checkColors(colors, adj, m, n, 0))
            return "YES";
        return "NO";

    }

    public static boolean checkColors(int[] colors, List<Integer>[] adj, int m, int n, int index) {
        if (index == n)
            return true;

        for (int i = 1; i <= m; i++) {
            if (canColor(index, adj, colors, i)) {
                colors[index] = i;
                if (checkColors(colors, adj, m, n, index + 1))
                    return true;
                colors[index] = 0;
            }
        }
        return false;

    }

    public static boolean canColor(int node, List<Integer>[] adj, int[] colors, int col) {

        for (int nodes : adj[node]) {
            if (colors[nodes] == col)
                return false;
        }
        return true;
    }
}
