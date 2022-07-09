public class aggresiveCows {

    public static int chessTournament(int[] positions, int n, int c) {
        // Write your code here.

        int low = 1;
        int high = positions[n - 1] - positions[0];
        int answer = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(positions, c, mid)) {
                low = mid + 1;
                answer = Math.max(answer, mid);
            } else
                high = mid - 1;
        }
        return answer;
    }

    private static boolean isPossible(int[] arr, int cows, int thresold) {

        int len = arr.length;
        int count = 0;
        for (int index = 1, i = 0; index < len; index++) {
            if (arr[index] - arr[i] >= thresold) {
                count++;
                i = index;
            }

        }
        return (count >= cows);
    }

}