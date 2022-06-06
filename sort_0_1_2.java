import java.util.*;
import java.io.*;

public class sort_0_1_2 {
    public static void sort012(int[] arr) {
        // Write your code here
        int len = arr.length;
        for (int oneindex = 0, zeroindex = 0, twoindex = len - 1; oneindex <= twoindex;) {
            switch (arr[oneindex]) {
                case 0:
                    swap(arr, oneindex, zeroindex);
                    oneindex++;
                    zeroindex++;
                    break;
                case 1:
                    oneindex++;
                    break;
                case 2:
                    swap(arr, oneindex, twoindex);
                    twoindex--;
                    break;
            }
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}