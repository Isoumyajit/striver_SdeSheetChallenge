import java.util.*;

public class palindromePartitions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        generateDP(str, dp);
        sc.close();
    }

    public static List<List<String>> partition(String s) {
        // Write your code here.
        int len = s.length();
        List<List<String>> answer = new ArrayList<>();
        List<String> helper = new ArrayList<>();

        if (len == 0) {
            answer.add(new ArrayList<String>());
            return answer;
        }
        if (len == 1) {
            answer.add(new ArrayList<String>());
            answer.get(0).add(s);
            return answer;
        }
        createpartitions(s, answer, helper, 0, len);
        return answer;

    }

    public static void createpartitions(String str, List<List<String>> answer, List<String> helper, int index,
            int len) {

        if (index == len) {
            answer.add(new ArrayList<>(helper));
            return;
        }
        for (int i = index; i < len; i++) {
            if (palindrome(str, index, i)) {
                helper.add(str.substring(index, i + 1));
                createpartitions(str, answer, helper, i + 1, len);
                helper.remove(helper.size() - 1);
            }
        }
    }

    public static boolean palindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    /*
     * Using a help from Dynamic Programming
     */

    private static void generateDP(String str, boolean[][] dp) {

        int len = str.length();
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        for (int i = 0, j = 1; j < len; i++, j++) {
            if (str.charAt(i) == str.charAt(j))
                dp[i][j] = true;
        }
        int index_count = 2;
        while (index_count < len) {
            int j = index_count;
            for (int i = 0; j < len; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (dp[i + 1][j - 1])
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                } else
                    dp[i][j] = false;
            }
        }
    }
}