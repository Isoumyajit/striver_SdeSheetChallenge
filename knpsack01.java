import java.util.ArrayList;

public class knpsack01 {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        // Write your code here.
        int[] dp = new int[n + 1];
        int answer = getMax(dp, n, w, 0, values, weights);
        return answer;
    }

    private static int getMax(int[] dp, int n, int currentCap, int index, ArrayList<Integer> val,
            ArrayList<Integer> weights) {

        if (currentCap == 0)
            return 0;
        if (index == n - 1) {
            if (weights.get(index) > currentCap)
                return 0;
            return val.get(index);
        }

        // pick up
        int option1 = 0;
        if (weights.get(index) <= currentCap)
            option1 = val.get(index) + getMax(dp, n, currentCap - weights.get(index), index + 1, val, weights);
        // not pick up
        int option2 = 0 + getMax(dp, n, currentCap, index + 1, val, weights);
        return Math.max(option2, option1);
    }
}