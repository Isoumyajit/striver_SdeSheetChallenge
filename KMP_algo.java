public class KMP_algo {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        if (p.length() == 0)
            return false;

        int i = 0;
        int j = 0;
        int c = 0;
        for (i = 0; i < s.length(); i++) {
            boolean flag = false;
            if (p.charAt(0) == s.charAt(i)) {
                flag = true;
                for (j = i, c = 0; j < i + p.length() && c < p.length() && j < s.length(); j++, c++) {
                    if (p.charAt(c) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && c != 0)
                return true;
        }
        return false;
    }
}