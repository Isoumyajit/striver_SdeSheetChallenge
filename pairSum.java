import java.util.*;
import java.io.*;

public class pairSum {
    public static int[][] pairSum(int[] arr, int s) {
        // Write your code here.

        int len = arr.length;
        if (len == 0 || len == 1)
            return new int[0][];
        if (len == 2) {
            if (arr[0] + arr[1] == s) {
                int[][] answer = new int[0][2];
                answer[0][0] = arr[0];
                answer[0][1] = arr[1];
            }
            return new int[0][];
        }
        List<ArrayList<Integer>> store = new LinkedList<>();
        Arrays.sort(arr);
        for (int index = 0; index < len - 1; index++) {

            int last = len - 1;
            while (last >= index + 1) {
                ArrayList<Integer> dummy = new ArrayList<>();
                if (arr[index] + arr[last] == s) {
                    dummy.add(arr[index]);
                    dummy.add(arr[last]);
                    last--;
                    store.add(dummy);
                } else if (arr[index] + arr[last] > s)
                    last--;
                else
                    break;

            }
        }
        // System.out.println(store);
        int[][] answer = new int[store.size()][2];
        for (int index = 0; index < store.size(); index++) {
            answer[index][0] = store.get(index).get(0);
            answer[index][1] = store.get(index).get(1);
        }
        return answer;
    }
}