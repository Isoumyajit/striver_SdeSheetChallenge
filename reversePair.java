import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class reversePair {
    public static int counts = 0;

    public static int reversePairs(ArrayList<Integer> arr) {
        // Write your code here.
        counts = 0;
        int len = arr.size();
        int[] arr1 = new int[len];
        int index = 0;
        for (int x : arr)
            arr1[index++] = x;
        merge(arr1, 0, len - 1);
        // for(int x : arr1)System.out.print(x+" ");
        return counts;

    }

    public static void merge(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + (high - low) / 2);
            merge(arr, low, mid);
            merge(arr, mid + 1, high);
            sort(arr, low, mid, mid + 1, high);
        }
    }

    public static void sort(int[] arr, int low1, int high1, int low2, int high2) {
        int l = low1;
        int h = high1;
        int l1 = low2;
        int h1 = high2;
        int index = 0;
        int j = low2;
        for (int i = low1; i <= high1; i++) {
            while (j <= high2 && arr[i] > 2 * arr[j]) {
                j++;
            }
            counts += (j - (low2));
        }
        int[] dummy = new int[h1 - l + 1];
        while (l <= h && l1 <= h1) {
            if (arr[l] <= arr[l1]) {
                dummy[index++] = arr[l++];
            } else {
                dummy[index++] = arr[l1++];
            }
        }
        while (l <= h) {
            dummy[index++] = arr[l++];
        }
        while (l1 <= h1) {
            dummy[index++] = arr[l1++];
        }
        for (int x = 0, count = low1; count <= high2; x++, count++) {
            arr[count] = dummy[x];
        }
    }
}