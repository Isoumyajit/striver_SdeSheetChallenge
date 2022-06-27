import java.util.*;

public class jobsequencing {
    public static int jobScheduling(int[][] jobs) {
        // Write your code here
        int len = jobs.length;
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        int profit = 0;
        int maxUnit = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            maxUnit = Math.max(maxUnit, jobs[index][0]);
        }
        int[] count = new int[maxUnit + 1];
        Arrays.fill(count, -1);

        for (int index = 0; index < len; index++) {
            if (count[jobs[index][0]] == -1) {
                count[jobs[index][0]] = jobs[index][1];
                profit += jobs[index][1];
            } else {
                int ind = jobs[index][0];
                while (ind > 0) {
                    if (count[ind] == -1) {
                        count[ind] = jobs[index][1];
                        profit += jobs[index][1];
                        break;
                    }
                    ind--;
                }
            }
        }
        return profit;
    }
}
