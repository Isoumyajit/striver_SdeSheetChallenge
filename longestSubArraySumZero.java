import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class longestSubArraySumZero {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        // Write your code here.
        int sum = 0;
        int len = arr.size();
        for (int index = 0; index < len; index++) {
            sum += arr.get(index);
        }
        if (sum == 0)
            return len;

        HashMap<Integer, Integer> helper = new HashMap<>();
        sum = 0;
        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;
        for (int index = 0; index < len; index++) {
            sum += arr.get(index);
            if (sum == 0) {
                curLen = index + 1;
            } else if (helper.containsKey(sum)) {
                curLen = index - helper.get(sum);

            } else
                helper.put(sum, index);
            maxLen = Math.max(maxLen, curLen);
        }
        if (maxLen == Integer.MIN_VALUE)
            return 0;
        return maxLen;
    }
}