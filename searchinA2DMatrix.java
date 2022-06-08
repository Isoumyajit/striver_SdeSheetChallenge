import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class searchinA2DMatrix {
    static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
        // Write your code here.
        if (m == 0)
            return false;
        if (m == 1 && n == 1) {
            if (mat.get(m - 1).get(n - 1) == target)
                return true;
            return false;
        }
        int col = n - 1;
        for (int row = 0; row < m; row++) {
            while (col >= 0) {
                // System.out.println(mat.get(row).get(col));
                if (target == mat.get(row).get(col))
                    return true;
                else if (target < mat.get(row).get(col))
                    col--;
                else
                    break;

            }
            if (col < 0)
                break;
        }
        return false;
    }
}
