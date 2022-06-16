import java.util.*;
import java.io.*;

public class longestStringwithoutRepeatatingChar {
    public static int uniqueSubstrings(String input) {
        // write your code here
        int len = input.length();
        int maxLen = Integer.MIN_VALUE;
        int[] hash = new int[26];
        int start = 0;
        Arrays.fill(hash, -1);
        for (int index = 0; index < len; index++) {
            if (hash[input.charAt(index) - 'a'] != -1) {
                int index_char = hash[input.charAt(index) - 'a'];

                maxLen = Math.max(maxLen, (index - 1) - start + 1);
                for (int i = start; i <= index_char; i++) {
                    hash[input.charAt(i) - 'a'] = -1;
                }
                hash[input.charAt(index) - 'a'] = index;
                start = index_char + 1;

            } else
                hash[input.charAt(index) - 'a'] = index;

        }
        maxLen = Math.max(maxLen, (len - 1) - start + 1);
        return maxLen;
    }
}
