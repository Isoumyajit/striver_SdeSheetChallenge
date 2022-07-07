import java.util.ArrayList;

public class singleElementInsortedArray {
    public static int uniqueElement(ArrayList<Integer> arr) {
        // Write your code here.
        int len = arr.size();
        int low = 0;
        int high = len - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid != low && mid != high && arr.get(mid) < arr.get(mid + 1) && arr.get(mid) > arr.get(mid - 1)) {
                answer = arr.get(mid);
                break;
            } else if (mid == 0 && arr.get(mid) < arr.get(mid + 1)) {
                answer = arr.get(mid);
                break;
            } else if (mid == len - 1 && arr.get(mid) > arr.get(mid - 1)) {
                answer = arr.get(mid);
                break;
            } else if (arr.get(mid) == arr.get(mid - 1)) {
                low = mid + 1;
            } else
                high = mid;
        }

        return answer;
    }
}