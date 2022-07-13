import java.util.ArrayList;
import java.util.Stack;

public class largestRectangleinHistogram {
    public static int largestRectangle(ArrayList<Integer> heights) {
        // Write your code here.

        int len = heights.size();
        Stack<Integer> helper = new Stack<>();

        int[] leftSmaller = new int[len];
        int[] rightSmaller = new int[len];

        // Finding the next smaller elements in the right side of the array
        for (int index = len - 1; index >= 0; index--) {
            if (helper.isEmpty()) {
                rightSmaller[index] = len;
                helper.push(index);
            } else {
                while (!helper.isEmpty() && heights.get(helper.peek()) >= heights.get(index)) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    rightSmaller[index] = len;
                } else
                    rightSmaller[index] = helper.peek();
                helper.push(index);
            }
        }

        // Finding the next greater element in the left side of the array
        helper.clear();
        for (int index = 0; index < len; index++) {
            if (helper.isEmpty()) {
                leftSmaller[index] = -1;
                helper.push(index);
            } else {
                while (!helper.isEmpty() && heights.get(helper.peek()) >= heights.get(index)) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    rightSmaller[index] = -1;
                } else
                    rightSmaller[index] = helper.peek();
                helper.push(index);
            }
        }

        // calculating max width
        int maxWidth = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            maxWidth = Math.max(maxWidth, (rightSmaller[index] - leftSmaller[index] - 1) * heights.get(index));
        }
        return maxWidth;
    }
}