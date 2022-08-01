public class minimumPathSum {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length + 1];
        return getMin(grid, 0, 0, dp);
    }

    private static int getMin(int[][] grid, int row, int col, Integer[][] dp) {

        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
        if (row < 0 || row == grid.length || col == grid[0].length)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];
        // left
        int right = grid[row][col] + getMin(grid, row, col + 1, dp);
        // down
        int down = grid[row][col] + getMin(grid, row + 1, col, dp);

        if (right == grid[row][col]) {
            dp[row][col] = down;
        } else if (down == grid[row][col])
            dp[row][col] = right;
        else
            dp[row][col] = Math.min(right, down);
        return dp[row][col];
    }
}