import java.util.*;
import java.io.*;

public class setMatrixZeros {
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int zero_count = 0;
        boolean first_row = false;
        boolean first_col = false;
        for (int index = 0; index < matrix[0].length; index++) {
            if (matrix[0][index] == 0) {
                first_row = true;
                break;
            }
        }
        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index][0] == 0) {
                first_col = true;
                break;
            }
        }
        for (int index = 0; index < matrix[0].length; index++)
            if (matrix[0][index] == 0)
                zero_count++;
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (first_row) {
            for (int index = 0; index < matrix[0].length; index++) {
                matrix[0][index] = 0;
            }
        }
        if (first_col) {
            for (int index = 0; index < matrix.length; index++) {
                matrix[index][0] = 0;
            }
        }
    }

}