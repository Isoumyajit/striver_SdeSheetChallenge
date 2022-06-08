import java.util.*;
import java.io.*;

public class mergeSortedArrays {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here
        int low = 0;
        int low1 = 0;
        int high = arr1.length;
        int high1 = arr2.length;
        int[] answer = new int[high];
        high -= high1;
        int index = 0;
        while (low < high && low1 < high1) {
            if (arr1[low] < arr2[low1]) {
                answer[index++] = arr1[low++];
            } else {
                answer[index++] = arr2[low1++];
            }
        }
        while (low < high) {
            answer[index++] = arr1[low++];
        }
        while (low1 < high1) {
            answer[index++] = arr2[low1++];
        }
        return answer;
    }
}
