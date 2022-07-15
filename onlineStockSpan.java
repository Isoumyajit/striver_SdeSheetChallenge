import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class onlineStockSpan {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.

        int len = price.size();

        Stack<Integer> helper = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int index = 0; index < len; index++) {
            if (index == 0) {
                helper.push(index);
                answer.add(1);
            } else {
                while (!helper.isEmpty() && price.get(helper.peek()) <= price.get(index)) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    answer.add(index + 1);
                } else {
                    answer.add(index - (helper.peek() + 1) + 1);
                }
                helper.push(index);
            }
        }
        Collections.reverse(answer);
        return answer;
    }
}