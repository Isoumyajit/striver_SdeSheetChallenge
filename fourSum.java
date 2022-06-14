import java.util.*;
import java.io.*;

public class fourSum {
    public static String fourSum(int[] arr, int target, int n) {
        // Write your code here.
        int len = arr.length;
        if (len == 4) {
            if (arr[0] + arr[1] + arr[2] + arr[3] == target)
                return "Yes";
            return "No";
        }
        Arrays.sort(arr);
        for (int index = 0; index < len - 3; index++) {
            if (index == 0 || arr[index] != arr[index - 1]) {
                int left = index + 1;
                while (left < len - 2) {
                    int a = left + 1;
                    int b = len - 1;
                    while (a < b) {
                        if (arr[index] + arr[left] + arr[a] + arr[b] == target) {
                            return "Yes";
                        } else if (arr[index] + arr[left] + arr[a] + arr[b] > target)
                            b--;
                        else
                            a++;
                    }
                    while (left < len - 2 && arr[left] == arr[left + 1])
                        left++;
                    left++;
                }
            }
        }
        return "No";
    }
}
