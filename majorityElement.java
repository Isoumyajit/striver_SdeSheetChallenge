import java.util.*;
import java.io.*;

public class majorityElement {
    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        int len = arr.length;
        int element = arr[0];
        int count = 1;
        for (int index = 1; index < len; index++) {
            if (element == arr[index]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    element = arr[index];
                    count = 1;
                }
            }
        }
        int check = 0;
        for (int index = 0; index < len; index++) {
            if (arr[index] == element)
                check++;
        }
        if (check > len / 2)
            return element;
        return -1;
    }
}