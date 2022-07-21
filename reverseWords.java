import java.util.*;

public class reverseWords {
    public static String reverseString(String str) {
        // Write your code here
        StringBuffer s = new StringBuffer(str.trim());
        s.reverse();
        StringBuffer helper = new StringBuffer();
        StringBuffer ans = new StringBuffer();

        for (int index = 0, j = 0; index < s.length(); index++) {

            if (helper.length() > 0 && s.charAt(index) == ' ') {
                helper.reverse();
                ans.append(helper.toString());
                if (index != s.length() - 1)
                    ans.append(" ");
                helper = new StringBuffer();
            } else if (s.charAt(index) != ' ')
                helper.append(s.charAt(index));
        }
        ans.append(helper.reverse());
        return ans.toString();
    }

}
