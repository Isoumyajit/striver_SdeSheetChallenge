import java.util.*;

public class combinationSum_I {
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (n == 0) {
            answer.add(temp);
            return answer;
        }
        createSubset(arr, temp, answer, 0, n, k, 0);
        // System.out.println(answer);
        return answer;
    }

    public static void createSubset(ArrayList<Integer> arr, ArrayList<Integer> helper,
            ArrayList<ArrayList<Integer>> answer, int index, int n, int k, int sum) {

        if (index == n) {
            if (k == sum) {
                ArrayList<Integer> dummy = new ArrayList<>(helper);
                answer.add(dummy);
            }
            return;
        }

        helper.add(arr.get(index));
        createSubset(arr, helper, answer, index + 1, n, k, sum + arr.get(index));
        helper.remove(helper.size() - 1);
        createSubset(arr, helper, answer, index + 1, n, k, sum);
    }
}