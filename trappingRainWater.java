import java.util.*;
import java.io.*;

public class trappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        System.out.println(getTrappedWater(arr, n));
        sc.close();
    }

    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.

        int water = 0;
        Stack<Long> helper = new Stack<>();
        int len = arr.length;
        long[] left = new long[len];
        long[] right = new long[len];
        int i = 0;
        for (int index = 0; index < len; index++) {
            if (arr[index] == 0) {
                left[i++] = helper.isEmpty() ? 0 : helper.peek();
            } else if (helper.size() == 0) {
                helper.push(arr[index]);
                left[i++] = arr[index];
            } else {
                boolean flag = false;
                while (!helper.isEmpty() && helper.peek() < arr[index]) {
                    flag = true;
                    helper.pop();
                }
                if (!helper.isEmpty()) {
                    left[i++] = helper.peek();
                } else
                    left[i++] = arr[index];
                if (flag)
                    helper.push(arr[index]);
            }
        }
        helper.removeAllElements();
        i = n - 1;
        for (int index = n - 1; index >= 0; index--) {
            if (arr[index] == 0) {
                right[i--] = helper.isEmpty() ? 0 : helper.peek();
            } else if (helper.size() == 0) {
                helper.push(arr[index]);
                right[i--] = arr[index];
            } else {
                boolean flag = false;
                while (!helper.isEmpty() && helper.peek() < arr[index]) {
                    flag = true;
                    helper.pop();
                }
                if (!helper.isEmpty()) {
                    right[i--] = helper.peek();

                } else
                    right[i--] = arr[index];
                if (flag)
                    helper.push(arr[index]);

            }
        }
        // for (int index = 0; index < n; index++) {
        // System.out.println(left[index] + " " + right[index]);
        // }
        for (int index = 0; index < n; index++) {
            water += Math.min(left[index], right[index]) - arr[index];
            // System.out.println(water);
        }

        return water;
    }
}
