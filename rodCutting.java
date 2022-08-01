import java.util.Arrays;

public class rodCutting {
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return getMax(price, 0, n, dp);
    }

    private static int getMax(int[] price, int index, int remain, int[][] dp) {

        if (remain <= 0 || remain < index + 1) {
            dp[index][remain] = 0;
            return 0;
        }

        if (index == price.length)
            return 0;

        if (dp[index + 1][remain] != -1)
            return dp[index + 1][remain];
        // pick up

        int ch1 = price[index] + getMax(price, index, remain - (index + 1), dp);

        // not pick up
        int ch2 = 0 + getMax(price, index + 1, remain, dp);

        dp[index + 1][remain] = Math.max(ch1, ch2);
        return dp[index + 1][remain];
    }
}