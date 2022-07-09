import java.util.Scanner;

public class allocatesBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        System.out.println(ayushGivesNinjatest(n, m, arr));
        sc.close();
    }

    public static long ayushGivesNinjatest(int n, int m, int[] time) {

        long high = 0;
        long low = Long.MAX_VALUE;
        long answer = Long.MAX_VALUE;

        for (int times : time)
            high += times;

        for (int i = 0; i < m; i++)
            low = Math.min(low, (long) time[i]);

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(time, mid, n)) {
                high = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static boolean isPossible(int[] arr, long mid, int day) {
        long pages = 0;
        long dayCount = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] + pages > mid) {
                pages = (long) arr[index];
                dayCount++;
                if (pages > mid)
                    return false;
            } else
                pages += (long) arr[index];
        }
        if (dayCount < (long) day)
            return true;
        else
            return false;
    }
}
