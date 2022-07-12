import java.util.Stack;

public class nextGreaterElement {

    public static int[] nextGreater(int[] arr, int n) {
        // Write Your code here
        int[] answer = new int[n];

        if (n == 0)
            return answer;
        if (n == 1) {
            answer[0] = -1;
            return answer;
        }

        Stack<Integer> helper = new Stack<>();
        for (int index = n - 1; index >= 0; index--) {
            if (helper.isEmpty()) {
                helper.add(arr[index]);
                answer[index] = -1;
            } else {
                while (!helper.isEmpty() && helper.peek() <= arr[index]) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    answer[index] = -1;
                } else
                    answer[index] = (helper.peek());
                helper.push(arr[index]);
            }
        }
        return answer;
    }

}
