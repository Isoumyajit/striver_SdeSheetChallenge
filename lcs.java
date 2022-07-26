
public class lcs {

    public static int lcs(String s, String t) {
        // Your code goes here
        int len = s.length();
        int len1 = t.length();

        int[][] helper = new int[len + 1][len1 + 1];
        for (int index = 0; index < len; index++) {
            for (int c = 0; c < len1; c++)
                helper[index][c] = -1;
        }
        int answer = longestComoonsubsequence(helper, len, len1, s, t, len - 1, len1 - 1);
        return answer;

    }

    private static int longestComoonsubsequence(int[][] helper, int len1, int len2, String s1, String s2, int index1,
            int index2) {

        if (index1 < 0 || index1 == len1 || index2 < 0 || index2 == len2)
            return 0;
        if (helper[index1][index2] != -1)
            return helper[index1][index2];
        if (s1.charAt(index1) == s2.charAt(index2))
            return 1 + longestComoonsubsequence(helper, len1, len2, s1, s2, index1 - 1, index2 - 1);
        else
            return Math.max(longestComoonsubsequence(helper, len1, len2, s1, s2, index1 - 1, index2),
                    longestComoonsubsequence(helper, len1, len2, s1, s2, index1, index2 - 1));
    }

    /*
     * Tabulation format of LCS bottom up approach
     * Space optimized approach Space Complexity - O(M*N) + No auxiliary space as we
     * don't use stack space
     * Time complexity - O(N*M)
     */

    private static int LCS(int[][] mat, String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        for (int index1 = 0; index1 <= len1; index1++) {
            for (int index2 = 0; index2 <= len2; index2++) {
                if (index1 == 0 || index2 == 0)
                    mat[index1][index2] = 0;
                else if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    mat[index1][index2] = 1 + mat[index1 - 1][index2 - 1];
                else
                    mat[index1][index2] = Math.max(mat[index1][index2 - 1], mat[index1 - 1][index2]);
            }
        }
        return mat[len1][len2];
    }

}