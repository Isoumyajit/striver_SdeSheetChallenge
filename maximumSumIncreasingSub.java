import java.util.*;

public class maximumSumIncreasingSub {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        int max = Collections.max(rack);
        Integer[][] dp = new Integer[n + 1][max + 1];
        int ans = getmaxWeight(rack, 0, 0, dp);
        return ans;
    }

    private static int getmaxWeight(ArrayList<Integer> arr, int index, int curWeight, Integer[][] dp) {

        if (index == arr.size())
            return 0;

        int op1 = 0;
        int op2 = 0;
        // pick
        if (dp[index][curWeight] != null)
            return dp[index][curWeight];
        if (curWeight < arr.get(index)) {

            op1 = arr.get(index) + getmaxWeight(arr, index + 1, arr.get(index), dp);
        }
        op2 = getmaxWeight(arr, index + 1, curWeight, dp);
        // System.out.println(arr.get(index) + " "+ curWeight +" "+op1+" "+op2);
        dp[index][curWeight] = Math.max(op1, op2);
        return dp[index][curWeight];
    }
}