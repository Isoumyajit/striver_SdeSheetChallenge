import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestElement {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        // Write your code here

        int len = arr.size();
        ArrayList<Integer> answer = new ArrayList<>();
        if (len == 0)
            return answer;
        PriorityQueue<Integer> helper = null;
        helper = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < len; index++) {
            helper.add(arr.get(index));
            if (helper.size() > k)
                helper.poll();
        }
        answer.add(helper.peek());
        helper = new PriorityQueue<>();
        for (int index = 0; index < len; index++) {
            helper.add(arr.get(index));
            if (helper.size() > k)
                helper.poll();
        }
        answer.add(helper.peek());
        return answer;
    }
}
