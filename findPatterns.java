import java.util.ArrayList;

public class findPatterns {
    public static ArrayList<Integer> stringMatch(String s, String pat) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Write your code here.
        int i = 0;
        int j = 0;
        int[] arr = new int[pat.length()];
        preProcess(arr, pat);
        int start = 0;
        for (i = 0, j = 0; i < s.length();) {
            if (j == pat.length()) {
                j = 0;
                ans.add(start);
                i = start + 1;
                start = i;
            } else if (s.charAt(i) == pat.charAt(j)) {
                j++;
                i++;
            } else if (j == 0) {
                i++;
                start = i;
            } else {
                j = arr[j - 1];
            }

        }
        if (j == pat.length() && i == s.length())
            ans.add(start);
        return ans;
    }

    private static void preProcess(int[] helper, String str) {

        int first = 0;
        int second = 0;
        for (first = 1; first < str.length();) {
            if (str.charAt(first) == str.charAt(second)) {
                helper[first] = second + 1;
                second += 1;
                first += 1;

            } else if (second == 0) {
                helper[first] = 0;
                first++;
            } else {
                second = helper[second - 1];
            }
        }
    }
}