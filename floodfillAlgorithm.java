public class floodfillAlgorithm {
    public static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        // Write your code here
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, x, y, newColor, visited, image[x][y]);
        return image;
    }

    private static void dfs(int[][] img, int x, int y, int newcolor, boolean visited[][], int prevcolor) {
        if (x == img.length || x < 0 || y < 0 || y == img[0].length)
            return;
        if (visited[x][y])
            return;
        if (img[x][y] != prevcolor)
            return;

        visited[x][y] = true;
        img[x][y] = newcolor;
        for (int[] direction : dirs) {
            dfs(img, x + direction[0], y + direction[1], newcolor, visited, prevcolor);
        }
    }
}
