import java.util.*;

public class waystoMakeCoinChange {

    public static long countWaysToMakeChange(int denominations[], int value) {
        // write your code here
        Arrays.sort(denominations);

        Long[][] dp = new Long[value + 1][value + 1];
        long ans = countChange(denominations, 0, dp, value);
        return ans;
    }

    private static long countChange(int[] arr, int index, Long[][] dp, int val) {
        if (index == arr.length) {
            if (val == 0) {

                return 1;
            }
            return 0;
        }
        if (val == 0) {
            return 1;
        }
        if (val < arr[index])
            return 0;
        if (dp[index][val] != null)
            return dp[index][val];
        // pick
        long ans1 = countChange(arr, index, dp, val - arr[index]);
        // not pick up
        long ans2 = countChange(arr, index + 1, dp, val);

        dp[index][val] = ans1 + ans2;
        return ans1 + ans2;
    }

}