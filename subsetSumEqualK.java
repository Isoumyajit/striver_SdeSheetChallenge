public class subsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        Boolean[][] dp = new Boolean[n][k + 1];
        return findSubset(dp, n, arr, 0, 0, k);
    }

    private static boolean findSubset(Boolean[][] dp, int n, int arr[], int index, int sum, int k) {
        if (sum > k)
            return false;
        if (index == n) {
            if (sum == k)
                return true;
            else
                return false;
        }

        if (dp[index][sum] != null)
            return dp[index][sum];
        // pick up
        boolean op1 = findSubset(dp, n, arr, index + 1, sum + arr[index], k);

        boolean op2 = findSubset(dp, n, arr, index + 1, sum, k);
        dp[index][sum] = op1 | op2;
        return op1 | op2;
    }
}
