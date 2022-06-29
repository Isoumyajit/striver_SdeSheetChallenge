import java.util.ArrayList;
import java.util.*;

public class combinationSum_II {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int k) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        if (n == 0) {
            answer.add(temp);
            return answer;
        }
        Collections.sort(arr);
        createSubset(arr, temp, answer, 0, n, k, 0);

        return answer;
    }

    public static void createSubset(ArrayList<Integer> arr, ArrayList<Integer> helper,
            ArrayList<ArrayList<Integer>> answer, int index, int n, int k, int sum) {

        if (k < sum)
            return;
        if (k == sum) {
            answer.add(new ArrayList<>(helper));
            return;
        }
        if (index == n) {
            return;
        }

        for (int i = index; i < n; i++) {
            if (arr.get(i) > k)
                break;
            if (i == index || arr.get(i) != arr.get(i - 1)) {
                helper.add(arr.get(i));
                createSubset(arr, helper, answer, i + 1, n, k, sum + arr.get(i));
                helper.remove(helper.size() - 1);

            }
        }
    }
}