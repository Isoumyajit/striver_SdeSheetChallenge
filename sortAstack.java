import java.util.*;

public class sortAstack {

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        PriorityQueue<Integer> helper = new PriorityQueue<>();
        while (!stack.isEmpty()) {
            helper.offer(stack.pop());
        }
        while (!helper.isEmpty()) {
            stack.push(helper.peek());
            helper.poll();
        }
    }

}