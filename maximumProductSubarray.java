import java.util.ArrayList;

public class maximumProductSubarray {
    public static int maximumProduct(ArrayList<Integer> arr, int n) {

        int answer = arr.get(0);
        int prod1 = arr.get(0);
        int prod2 = arr.get(0);
        for (int index = 1; index < n; index++) {

            int value = Math.max(arr.get(index), Math.max(prod1 * arr.get(index), arr.get(index) * prod2));
            prod2 = Math.min(arr.get(index), Math.min(prod1 * arr.get(index), prod2 * arr.get(index)));

            prod1 = value;
            answer = Math.max(answer, prod1);
        }
        return answer;
    }

}