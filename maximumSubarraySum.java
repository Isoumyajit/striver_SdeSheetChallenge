import java.util.*;
import java.io.*;

public class maximumSubarraySum {

    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here

        long sum = 0;
        long currsum = Long.MIN_VALUE;
        int len = arr.length;
        if (len == 1)
            return arr[0];

        for (int index = 0; index < len; index++) {
            sum += arr[index];
            if (sum < arr[index]) {
                sum = arr[index];
            }
            if (currsum < sum) {
                currsum = sum;
            }
        }
        if (currsum < 0)
            return 0;
        return currsum;
    }

}
