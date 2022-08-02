import java.util.*;

public class maximumOfminimumOfeveryWindow {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] aux = new int[a.length];
        Arrays.fill(aux, Integer.MIN_VALUE);
        rightSmaller(a, right);
        leftSmaller(a, left);
        // for(int i = 0 ; i < a.length ; i++)System.out.println(right[i]+" "+left[i]);
        for (int i = 0; i < a.length; i++) {
            int l = right[i] - left[i] - 1;
            aux[l - 1] = Math.max(a[i], aux[l - 1]);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            aux[i] = Math.max(aux[i], aux[i + 1]);
        }

        return aux;
    }

    private static void rightSmaller(int[] arr, int[] right) {

        Stack<Integer> helper = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                helper.push(i);
                right[i] = arr.length;
            } else {
                while (!helper.isEmpty() && arr[helper.peek()] >= arr[i]) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    helper.push(i);
                    right[i] = arr.length;
                } else {
                    right[i] = helper.peek();
                    helper.push(i);
                }
            }

        }
    }

    private static void leftSmaller(int[] arr, int left[]) {
        Stack<Integer> helper = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                helper.push(i);
                left[i] = -1;
            } else {
                while (!helper.isEmpty() && arr[helper.peek()] >= arr[i]) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    helper.push(i);
                    left[i] = -1;
                } else {

                    left[i] = helper.peek();
                    helper.push(i);
                }
            }

        }
    }
}
