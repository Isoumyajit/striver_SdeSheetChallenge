import java.util.*;

public class maximumMeeting {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        // Write your code here
        List<Integer> answer = new ArrayList<Integer>();
        if (start.length != end.length)
            return answer;

        int n = start.length;
        int[][] arr = new int[n][3];
        for (int index = 0; index < n; index++) {
            arr[index][0] = start[index];
            arr[index][1] = end[index];
            arr[index][2] = index + 1;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        answer.add(arr[0][2]);
        int s = arr[0][0];
        int e = arr[0][1];
        for (int index = 1; index < n; index++) {
            if (e < arr[index][0]) {
                s = arr[index][0];
                e = arr[index][1];
                answer.add(arr[index][2]);
            }
        }
        return answer;
    }
}