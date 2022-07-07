import java.util.ArrayList;

public class ratInaMaze {

    public static void main(String[] args) {

        int[][] maze = { { 1, 0, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        int n = maze.length;
        System.out.println(ratInAMaze(maze, n));
    }

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int[][] goodmazes = new int[n][n];
        maze(maze, goodmazes, n, 0, 0, answer);
        return answer;
    }

    public static void maze(int[][] arr, int[][] goodmazes, int n, int row, int col,
            ArrayList<ArrayList<Integer>> answer) {

        if (row == n - 1 && col == n - 1) {
            goodmazes[n - 1][n - 1] = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int[] x : goodmazes) {
                for (int a : x) {
                    temp.add(a);
                }
            }
            answer.add(temp);
            return;
        }
        if (row < 0 || row == n || col == n || col < 0)
            return;

        if (arr[row][col] == 0)
            return;
        if (goodmazes[row][col] != 1) {
            goodmazes[row][col] = 1;
            maze(arr, goodmazes, n, row + 1, col, answer);
            maze(arr, goodmazes, n, row, col - 1, answer);
            maze(arr, goodmazes, n, row, col + 1, answer);
            maze(arr, goodmazes, n, row - 1, col, answer);
            goodmazes[row][col] = 0;
        }
        return;

    }
}