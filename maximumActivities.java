import java.util.Arrays;

public class maximumActivities {
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        // Write your code here
        if (start.length != end.length)
            return 0;
        int len = start.length;
        if (len == 1)
            return 1;

        long[][] helper = new long[len][2];
        for (int index = 0; index < len; index++) {
            helper[index][0] = start[index];
            helper[index][1] = end[index];
        }
        Arrays.sort(helper, (a, b) -> Long.compare(a[1], b[1]));

        long e = helper[0][1];
        int count = 1;

        for (int index = 1; index < len; index++) {
            if (e < helper[index][0]) {
                e = helper[index][1];
                count++;
            }
        }
        return count;
    }
}
