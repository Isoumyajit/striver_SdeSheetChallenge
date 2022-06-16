import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class longessubArraywithGivenXor {
    public static int subarraysXor(ArrayList<Integer> arr, int target) {
        // Write your code here.
        int len = arr.size();
        Map<Integer, Integer> helper = new HashMap<>();
        int count = 0;
        int curXor = 0;
        for (int x : arr) {
            curXor ^= x;
            if (curXor == target)
                count++;
            if (helper.containsKey(curXor ^ target))
                count += helper.get(curXor ^ target);
            helper.put(curXor, helper.getOrDefault(curXor, 0) + 1);
        }
        return count;
    }
}