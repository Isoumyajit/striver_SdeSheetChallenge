import java.util.*;
import java.io.*;

public class threeSum {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int k) {

        // Write your code here.

        ArrayList<ArrayList<Integer>> helper = new ArrayList<ArrayList<Integer>>();
        if (n < 3)
            return helper;
        Arrays.sort(arr);
        for (int index = 0; index < n - 2; index++) {
            if (index == 0 || arr[index] != arr[index - 1]) {
                int left = index + 1;
                int right = n - 1;
                while (left < right) {
                    if (arr[left] + arr[right] + arr[index] == k) {
                        ArrayList<Integer> dummy = new ArrayList<>(Arrays.asList(arr[index], arr[left], arr[right]));
                        helper.add(dummy);

                        while (left < right && arr[left] == arr[left + 1])
                            left++;
                        while (right > left && arr[right] == arr[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (arr[index] + arr[left] + arr[right] > k)
                        right--;
                    else
                        left++;
                }
            }
        }
        return helper;
    }
}
