import java.util.*;

public class palindromePartitions {
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
}