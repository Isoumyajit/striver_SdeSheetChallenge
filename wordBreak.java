import java.util.*;

public class wordBreak {
    public static Boolean wordBreakI(String[] arr, int n, String target) {
        // Write your code here.
        ArrayList<String> helper = new ArrayList<>();
        ArrayList<String> dic = new ArrayList<>();
        Boolean[][] dp = new Boolean[target.length() + 1][target.length() + 1];

        for (int i = 0; i < n; i++)
            dic.add(arr[i]);
        return isPresent(dp, helper, dic, 0, target);
    }

    private static boolean isPresent(Boolean[][] dp, ArrayList<String> helper, ArrayList<String> dic, int index,
            String target) {

        if (index == target.length()) {
            return true;
        }

        StringBuffer st = new StringBuffer();
        for (int i = index; i < target.length(); i++) {
            st.append(target.charAt(i));
            if (dp[index][i] != null)
                return dp[index][i];
            if (dic.contains(st.toString())) {
                helper.add(st.toString());
                dp[index][i] = isPresent(dp, helper, dic, i + 1, target);
                if (dp[index][i])
                    return true;
                helper.remove(helper.size() - 1);
            }
        }
        return false;
    }
}