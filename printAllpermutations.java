import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class printAllpermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(findPermutations(str));
        sc.close();

    }

    public static List<String> findPermutations(String s) {
        // Write your code here.
        int len = s.length();
        List<String> answer = new ArrayList<>();
        StringBuffer str = new StringBuffer(s);
        createPermutations(str, answer, 0, len);
        return answer;
    }

    public static void createPermutations(StringBuffer s, List<String> answer, int index, int len) {

        if (index == len) {
            answer.add(s.toString());
            return;
        }

        for (int i = index; i < len; i++) {
            swap(s, i, index);
            createPermutations(s, answer, index + 1, len);
            swap(s, i, index);
        }
    }

    public static void swap(StringBuffer s, int a, int b) {

        char x = s.charAt(a);
        char y = s.charAt(b);
        s.setCharAt(a, y);
        s.setCharAt(b, x);
    }
}