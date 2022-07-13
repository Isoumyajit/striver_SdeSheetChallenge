
import java.util.*;

public class largestIneveryWindow {

    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        ArrayList<Integer> answer = new ArrayList<>();
        if (k == 1) {
            for (int a : nums)
                answer.add(a);
            return answer;
        }
        Deque<Integer> helper = new LinkedList<>();
        int window = n - 1;
        for (int index = n - 1; index >= 0; index--) {
            if (index == n - 1) {
                helper.add(index);
            } else {
                while (!helper.isEmpty() && nums.get(helper.peekLast()) < nums.get(index)) {
                    helper.pollLast();
                }
                if (Math.abs(window - index) + 1 == k && helper.isEmpty()) {
                    answer.add(nums.get(index));
                    window--;
                } else if (!helper.isEmpty() && Math.abs(window - index) + 1 == k) {

                    answer.add(nums.get(helper.peekFirst()));
                    if (Math.abs(helper.peekFirst() - index) + 1 == k)
                        helper.pollFirst();
                    window--;
                }
                helper.addLast(index);
            }
        }
        Collections.reverse(answer);
        return answer;
    }
}