import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class rotateMatrix {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int temp = 0;
        int l = 0;
        int r = 0;
        int rows = mat.size();
        int cols = mat.get(0).size();
        while (l + 1 < rows && r + 1 < cols) {

            int prev = mat.get(l).get(r);
            for (int i = r + 1; i < cols; i++) {
                temp = mat.get(l).get(i);
                mat.get(l).set(i, prev);
                prev = temp;
            }
            l++;
            for (int i = l; i < rows; i++) {
                temp = mat.get(i).get(cols - 1);
                mat.get(i).set(cols - 1, prev);
                prev = temp;
            }
            cols--;
            for (int i = cols - 1; i >= r; i--) {
                temp = mat.get(rows - 1).get(i);
                mat.get(rows - 1).set(i, prev);
                prev = temp;
            }
            rows--;
            for (int i = rows - 1; i >= l; i--) {
                temp = mat.get(i).get(r);
                mat.get(i).set(r, prev);
                prev = temp;
            }
            r++;
            mat.get(l - 1).set(r - 1, temp);
            // System.out.println(mat +" "+temp);
        }
    }
}
