
public class validSudoku {

    public static boolean isItSudoku(int matrix[][]) {

        // Write your code here.
        return isSudoku(matrix);

    }

    public static boolean isSudoku(int[][] sudoku) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (sudoku[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isPossible(sudoku, row, col, num)) {
                            sudoku[row][col] = num;
                            if (isSudoku(sudoku))
                                return true;
                            sudoku[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPossible(int[][] sudoku, int row, int col, int number) {

        for (int index = 0; index < 9; index++) {
            if (sudoku[row][index] == number)
                return false;

            if (sudoku[index][col] == number)
                return false;

            if (sudoku[3 * (row / 3) + index / 3][3 * (col / 3) + index % 3] == number)
                return false;
        }
        return true;

    }

}
