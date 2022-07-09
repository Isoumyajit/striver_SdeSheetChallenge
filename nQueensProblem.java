import java.util.ArrayList;
import java.util.Scanner;

public class nQueensProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solveNQueens(n));
        sc.close();
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int[][] chessBoard = new int[n][n];
        placeQueens(chessBoard, answer, 0);
        return answer;

    }

    public static void placeQueens(int[][] chessBoard, ArrayList<ArrayList<Integer>> answer, int curCol) {

        int len = chessBoard.length;
        if (curCol == len) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int[] x : chessBoard) {
                for (int a : x) {
                    temp.add(a);
                }
            }
            answer.add(temp);
            return;
        }
        for (int row = 0; row < len; row++) {
            if (isPossible(chessBoard, row, curCol)) {
                chessBoard[row][curCol] = 1;
                placeQueens(chessBoard, answer, curCol + 1);
                chessBoard[row][curCol] = 0;
            }
        }

        return;
    }

    public static boolean isPossible(int[][] chessBoard, int row, int col) {

        int r = row;
        int c = col;
        for (; r >= 0 && c >= 0; r--, c--) {
            if (chessBoard[r][c] == 1)
                return false;
        }
        r = row;
        c = col;

        for (int index = 0; index < row; index++) {
            if (chessBoard[index][col] == 1)
                return false;
        }
        for (int index = 0; index < col; index++) {
            if (chessBoard[row][index] == 1)
                return false;
        }
        r = row;
        c = col;

        for (; r < chessBoard.length && c >= 0; r++, c--) {
            if (chessBoard[r][c] == 1)
                return false;
        }
        return true;
    }
}