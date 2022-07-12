import java.util.*;

public class nextSmallerElement {
    static ArrayList<Integer> nextsmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.

        ArrayList<Integer> answer = new ArrayList<>();
        int len = arr.size();
        if (len == 0)
            return answer;
        if (len == 1) {
            answer.add(-1);
            return answer;
        }

        Stack<Integer> helper = new Stack<>();
        for (int index = len - 1; index >= 0; index--) {
            if (helper.isEmpty()) {
                helper.add(arr.get(index));
                answer.add(-1);
            } else {
                while (!helper.isEmpty() && helper.peek() >= arr.get(index)) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    answer.add(-1);
                } else
                    answer.add(helper.peek());
                helper.push(arr.get(index));
            }
        }
        return answer;
    }
}