import java.util.ArrayList;

public class matrixMedian {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        ArrayList<Integer> merged = new ArrayList<>();
        for (ArrayList<Integer> dummy : matrix) {
            merge(dummy, merged);
            // System.out.println(merged);
        }

        return merged.get((merged.size() + 0) / 2);
    }

    public static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> helper = new ArrayList<>();
        int low = 0;
        int high = arr1.size() - 1;
        int low2 = 0;
        int high2 = arr2.size() - 1;

        while (low <= high && low2 <= high2) {
            if (arr1.get(low) < arr2.get(low2)) {
                helper.add(arr1.get(low));
                low++;
            } else {
                helper.add(arr2.get(low2));
                low2++;
            }
        }
        while (low <= high) {
            helper.add(arr1.get(low));
            low++;
        }
        while (low2 <= high2) {
            helper.add(arr2.get(low2));
            low2++;
        }
        arr2.clear();
        for (int i = 0; i < helper.size(); i++) {
            arr2.add(i, helper.get(i));
        }
        return;
    }

    /*
     * Another Optimal Approach using Binary Searching
     * Time Complexity - O(R*C LOg(R*C))
     * Space complexity - O(1)
     */

    public static int searchMedian(ArrayList<ArrayList<Integer>> mat) {

        int m = mat.size();
        int n = mat.get(0).size();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, mat.get(i).get(n - 1));
            min = Math.min(min, mat.get(i).get(0));
        }

        int low = min;
        int high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int prevcount = 0;
            int row = 0;
            int col = 0;
            for (int i = row; i < m; i++) {
                while (mat.get(row).get(col) <= mid) {
                    prevcount++;
                }
            }
            if (prevcount >= (m * n + 1) / 2)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

}