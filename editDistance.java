
public class editDistance {

    public static int editDistance_(String str1, String str2) {
        // Your code goes here

        Integer[][] dp = new Integer[str1.length() + 1][str1.length() + 1];
        int minOp = findMinOpearation(str1, str2, str1.length() - 1, str2.length() - 1, dp);

        return minOp;
    }

    private static int findMinOpearation(String s1, String s2, int index1, int index2, Integer[][] dp) {

        if (index1 < 0 && index2 >= 0) {
            return index2 - 0 + 1;
        } else if (index2 < 0 && index1 >= 0) {
            return index1 - 0 + 1;
        } else if (index1 < 0 && index2 < 0)
            return 0;
        if (dp[index1][index2] != null)
            return dp[index1][index2];
        if (s1.charAt(index1) == s2.charAt(index2))
            return findMinOpearation(s1, s2, index1 - 1, index2 - 1, dp);
        int op1 = 1 + findMinOpearation(s1, s2, index1, index2 - 1, dp);
        int op2 = 1 + findMinOpearation(s1, s2, index1 - 1, index2, dp);
        int op3 = 1 + findMinOpearation(s1, s2, index1 - 1, index2 - 1, dp);

        dp[index1][index2] = Math.min(op1, Math.min(op2, op3));
        return dp[index1][index2];
    }
}