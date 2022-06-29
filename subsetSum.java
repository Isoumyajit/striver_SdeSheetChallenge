import java.util.*;

public class subsetSum {
    public static ArrayList<Integer> subsetSum(int nums[]) {
        // Write your code here..
        int len = nums.length;
        ArrayList<Integer> answer = new ArrayList<>();
        if (len == 1) {
            answer.add(0);
            answer.add(nums[0]);
            return answer;
        }

        createSubset(nums, answer, 0, len, 0);
        Collections.sort(answer);
        return answer;

    }

    public static void createSubset(int[] arr, ArrayList<Integer> helper, int index, int n, int sum) {

        if (n == index) {
            helper.add(sum);
            return;
        }
        createSubset(arr, helper, index + 1, n, sum + arr[index]);
        createSubset(arr, helper, index + 1, n, sum);
    }

}