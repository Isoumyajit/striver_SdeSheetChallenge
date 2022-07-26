import java.util.*;

public class longestpalindromicSubstring {
    public static String longestPalinSubstring(String str) {
        // Write your code here.
        int len = str.length();
        if (len == 1 || len == 0)
            return str;

        int[][] mat = new int[len][len];
        for (int index = 0; index < len; index++) {
            for (int c = 0; c < len; c++) {
                mat[index][c] = -1;
            }
        }

        for (int r = 0; r < len; r++) {
            mat[r][r] = 0;
        }

        for (int r = 0; r < len - 1; r++) {
            if (str.charAt(r) == str.charAt(r + 1))
                mat[r][r + 1] = 1;
        }

        int curlen = 2;
        while (curlen < len) {
            for (int i = 0, j = curlen; j < len; j++, i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (mat[i + 1][j - 1] != -1) {
                        mat[i][j] = curlen;
                    } else
                        mat[i][j] = -1;
                } else
                    mat[i][j] = -1;
            }
            curlen++;
        }

        int row = -1;
        int col = -1;
        int maxindex = -1;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (mat[r][c] > maxindex) {
                    maxindex = mat[r][c];
                    row = r;
                    col = c;
                }
                // System.out.print(mat[r][c] +" ");
            }
            // System.out.println();
        }
        String answer = "";
        for (int i = row; i <= col; i++)
            answer += str.charAt(i);
        return answer;
    }
}
