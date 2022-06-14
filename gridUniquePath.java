public class gridUniquePath {

    public static int uniquePaths(int m, int n) {
        // Write your code here.
        if (m == 0 || n == 0)
            return 1;
        int[][] helper = new int[m][n];
        for (int index = 0; index < n; index++) {
            helper[m - 1][index] = 1;
        }
        for (int index = 0; index < m; index++) {
            helper[index][n - 1] = 1;
        }
        for (int col = n - 2; col >= 0; col--) {
            for (int row = m - 2; row >= 0; row--) {
                helper[row][col] = helper[row + 1][col] + helper[row][col + 1];
            }
        }
        return helper[0][0];
    }

    // Learning Comination Trick
    public static int uniquePathsCombination(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        int numerator = m - n + 2;
        int denomenator = m - 1;
        int res = 1;
        for (int count = 1; count <= denomenator; count++) {
            res = res * (numerator - denomenator + count) / count;
        }
        return res;
    }
}
