import java.util.*;

public class minimumPlatforms {
    public static int calculateMinPatforms(int arr[], int dep[], int n) {
        // Write your code here.

        Arrays.sort(arr);
        Arrays.sort(dep);
        int j = 0, max_count = 1, count = 1;
        for (int i = 1; i < n;) {
            if (arr[i] > dep[j]) {
                j++;
                count--;
            } else if (arr[i] <= dep[j]) {
                i++;
                count++;
            }
            if (max_count < count)
                max_count = count;
        }
        return max_count;
    }

    public static int calculateMinPatformsOptimized(int[] arr, int[] dep, int n) {
        return 0;
    }
}
