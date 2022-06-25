import java.util.ArrayList;

public class maximumConsecutiveOne {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.

        int count = 0;
        int max_Len = Integer.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            if (arr.get(index) == 0)
                count++;
        }
        if (count == n) {
            if (k <= n)
                return k;
            else
                return n;
        } else {
            int[] hash = new int[2];

            for (int index = 0, j = 0; index < n; index++) {
                if (arr.get(index) == 1) {
                    hash[arr.get(index)]++;
                } else {
                    hash[arr.get(index)]++;
                    if (hash[arr.get(index)] > k) {
                        while (j < index) {
                            hash[arr.get(j)]--;
                            j++;
                            if (hash[0] <= k)
                                break;
                        }
                    }
                }
                max_Len = Math.max(max_Len, hash[0] + hash[1]);
            }
        }
        return max_Len;
    }
}