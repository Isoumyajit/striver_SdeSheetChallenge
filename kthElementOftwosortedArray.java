public class kthElementOftwosortedArray {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.

        if (m > n) {
            int[] temp = row2;
            row2 = row1;
            row1 = temp;
        }

        int low = 0;
        int high = n - 1;
        int total = (m + n);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int lefthalf = (total + 1) / k - mid;

            int a1 = (mid == 0) ? Integer.MIN_VALUE : row1[mid - 1];
            int a2 = (mid == m) ? Integer.MAX_VALUE : row1[mid];
            int b1 = (lefthalf == 0) ? Integer.MIN_VALUE : row2[lefthalf - 1];
            int b2 = (lefthalf == n) ? Integer.MAX_VALUE : row2[lefthalf];

            if (a1 <= b2 && b1 <= a2) {
                return Math.min(a1, b1);
            } else if (b1 > a2)
                high = mid - 1;
            else
                low = mid + 1;

        }
        return 0;
    }
}
