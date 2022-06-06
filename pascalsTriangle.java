import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class pascalsTriangle {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Long>> answer = new ArrayList<ArrayList<Long>>();
        for (int row = 0; row < n; row++) {
            ArrayList<Long> helper = new ArrayList<Long>();
            for (int col = 0; col <= row; col++) {

                if (row == 0 || col == 0 || col == row) {
                    helper.add(Long.valueOf(1));
                } else {
                    helper.add(answer.get(row - 1).get(col - 1) + answer.get(row - 1).get(col));
                }
            }
            answer.add(helper);
        }
        return answer;
    }
}
