import java.util.*;

public class longestIncreasingsubsequence {

    // private static int maxLen = Integer.MIN_VALUE;
    public static int longestIncreasingSubsequence(int arr[]) {
        // Your code goes here
        if (arr.length == 0)
            return 0;
        int[][] helper = new int[arr.length][arr.length + 1];
        for (int[] a : helper) {
            Arrays.fill(a, -1);
        }
        int answer = getMaxLen(helper, arr, 0, -1);
        return answer;
    }

    private static int getMaxLen(int[][] helper, int[] arr, int index, int prev) {

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int len = helper[i + 1][j + 1];
                if (prev == -1 || arr[prev] < arr[index]) {
                    len = Math.max(len, 1 + helper[i + 1][i + 1]);
                }
                helper[i][j] = len;
            }
        }
    }

}