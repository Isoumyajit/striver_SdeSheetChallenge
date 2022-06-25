import java.util.*;

public class removeDuplicates {
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int count = 0;
        for (int index = 1; index < arr.size(); index++) {
            if (arr.get(index) == arr.get(index - 1)) {
                count++;
            }
        }
        return arr.size() - count;
    }
}