import java.util.*;

public class heightfrominorderandlevel {
    static int search(int arr[], int strt,
            int end, int value) {
        for (int i = strt; i <= end; i++)
            if (arr[i] == value)
                return i;
        return -1;
    }

    static int getHeight(int in[], int level[],
            int start, int end, int n) {

        // Base Case
        if (start > end)
            return 0;

        int getIndex = search(in, start, end, level[0]);

        if (getIndex == -1)
            return 0;

        int leftCount = getIndex - start;

        int rightCount = end - getIndex;

        int[] newLeftLevel = new int[leftCount];
        int[] newRightLevel = new int[rightCount];

        int lheight = 0, rheight = 0;
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = start; j < getIndex; j++) {
                if (level[i] == in[j]) {
                    newLeftLevel[k] = level[i];
                    k++;
                    break;
                }
            }
        }

        k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = getIndex + 1; j <= end; j++) {
                if (level[i] == in[j]) {
                    newRightLevel[k] = level[i];
                    k++;
                    break;
                }
            }
        }

        if (leftCount > 0)
            lheight = getHeight(in, newLeftLevel, start,
                    getIndex - 1, leftCount);

        if (rightCount > 0)
            rheight = getHeight(in, newRightLevel,
                    getIndex + 1, end, rightCount);

        int height = Math.max(lheight + 1, rheight + 1);
        newRightLevel = null;
        newLeftLevel = null;

        return height;
    }
}