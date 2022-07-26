public class countIslands {
    private static int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 },
            { -1, -1 } };

    public static int getTotalIslands(int[][] mat) {
        // Your code goes here

        int islandCount = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                if (mat[r][c] == 1) {
                    dfs(mat, r, c);
                    islandCount += 1;
                }
            }
        }
        return islandCount;
    }

    private static void dfs(int[][] mat, int r, int c) {
        if (r < 0 || r == mat.length || c < 0 || c == mat[0].length)
            return;
        if (mat[r][c] == 0)
            return;
        mat[r][c] = 0;
        for (int[] direction : dirs) {
            dfs(mat, r + direction[0], c + direction[1]);
        }
    }
}