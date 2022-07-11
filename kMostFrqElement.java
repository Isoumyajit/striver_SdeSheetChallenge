import java.util.*;

public class kMostFrqElement {

    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        int[] ans = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(a.getKey(), b.getKey())
                        : Integer.compare(a.getValue(), b.getValue()));
        Map<Integer, Integer> hm = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {

            hm.put(arr[index], hm.getOrDefault(arr[index], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> mp : hm.entrySet()) {
            heap.add(mp);
            if (heap.size() > k)
                heap.poll();
        }
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i++] = heap.poll().getKey();
        }
        return ans;
    }
}
