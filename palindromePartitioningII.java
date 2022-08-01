import java.util.*;

public class palindromePartitioningII {

    public static int palindromePartitioning(String str) {
        // Write your code here
        ArrayList<String> helper = new ArrayList<>();
        int ans = makePartitions(new Integer[str.length() + 1][str.length() + 1], str, helper, 0, str.length());

        return ans - 1;

    }

    private static int makePartitions(Integer[][] dp, String s, ArrayList<String> helper, int index, int n) {

        if (index == n) {
            // System.out.println(helper);
            return 0;
        }

        int cuts = 0;
        int min_cuts = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i] != null)
                min_cuts = Math.min(dp[index][i], min_cuts);
            else if (isPalindrome(s, index, i)) {
                helper.add(s.substring(index, i + 1));
                cuts = 1 + makePartitions(dp, s, helper, i + 1, n);
                min_cuts = Math.min(min_cuts, cuts);
                dp[index][i] = min_cuts;
                helper.remove(helper.size() - 1);
            }
        }

        return min_cuts;
    }

    private static boolean isPalindrome(String s, int a, int b) {
        for (int i = a, j = b; i < b; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

}
