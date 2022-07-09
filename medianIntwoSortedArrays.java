public class medianIntwoSortedArrays {
    public static double median(int[] a, int[] b) {
        // Write your code here.

        if (a.length > b.length) {
            int[] temp = b;
            b = a;
            a = temp;
        }
        int low = 0;
        int high = a.length;

        int total = (a.length + b.length);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int leftinLeft = (total + 1) / 2 - mid;

            int amiddle = (mid == 0) ? Integer.MIN_VALUE : a[mid - 1];
            int aleftVal = (mid == a.length) ? Integer.MAX_VALUE : a[mid];

            int brightVal = (leftinLeft == 0) ? Integer.MIN_VALUE : b[leftinLeft - 1];
            int brightVal1 = (leftinLeft == b.length) ? Integer.MAX_VALUE : b[leftinLeft];

            if (amiddle <= brightVal1 && brightVal <= aleftVal) {
                if (total % 2 == 0) {
                    return ((double) Math.min(aleftVal, brightVal1) + (double) Math.max(amiddle, brightVal))
                            / (double) 2;
                } else
                    return (double) Math.max(amiddle, brightVal);
            } else if (aleftVal > brightVal)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 2.0;
    }
}