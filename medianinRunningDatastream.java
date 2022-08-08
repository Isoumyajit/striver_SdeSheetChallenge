import java.util.*;

public class medianinRunningDatastream {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        int[] ans = new int[arr.length];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int median = arr[0];
        max.offer(median);
        ans[0] = max.peek();
        for (int i = 1; i < n; i++) {

            int current = arr[i];
            if (max.size() > min.size()) {
                if (current < median) {
                    min.offer(max.remove());
                    max.offer(current);
                } else
                    min.offer(current);
                median = (int) Math.floor(((long) max.peek() + (long) min.peek()) / 2.0);
            } else if (max.size() == min.size()) {
                if (current < median) {
                    max.offer(current);
                    median = max.peek();
                } else {
                    min.offer(current);
                    median = min.peek();
                }
            } else {
                if (current > median) {
                    max.offer(min.remove());
                    min.offer(current);
                } else {
                    max.offer(current);

                }
                median = (int) Math.floor(((long) min.peek() + (long) max.peek()) / 2.0);
            }
            ans[i] = median;
        }
        return ans;
    }

}
