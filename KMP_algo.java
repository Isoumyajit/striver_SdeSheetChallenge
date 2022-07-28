public class KMP_algo {
    public static boolean findPattern(String p, String s) {
        if (p.length() == 0)
            return false;

        int i = 0;
        int j = 0;
        int[] arr = new int[p.length()];
        preProcess(arr, p);
        boolean flag = true;
        for (i = 0, j = 0; i < s.length() && j < p.length();) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
                i++;
            } else if (j == 0)
                i++;
            else {
                j = arr[j - 1];
            }

        }
        if (j == p.length())
            return true;
        return false;
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