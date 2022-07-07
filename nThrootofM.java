public class nThrootofM {
    public static double findNthRootOfM(int n, long m) {
        // Write your code here.
        double start = 1.0;
        double end = n;
        double mid = 1;
        double thresold = 1e-7;
        while ((end - start) >= thresold) {
            mid = (end + start) / 2.0;
            double multi = 1.0;
            for (int index = 1; index <= n; index++) {
                multi = multi * mid;
            }

            if (multi < m) {
                start = mid;
            } else
                end = mid;
        }
        return mid;
    }
}