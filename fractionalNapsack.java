
import java.util.*;

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

}

class itemcompare implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        double val1 = (double) a.value / (double) a.weight;
        double val2 = (double) b.value / (double) b.weight;
        if (val1 < val2)
            return 1;
        else if (val1 > val2)
            return -1;
        else
            return 0;
    }
}

public class fractionalNapsack {

    public static double maximumValue(Pair[] items, int n, int w) {
        // Write your code here.
        // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, new itemcompare());

        double maxVal = 0;
        for (int index = 0; index < n; index++) {
            if (items[index].weight <= w) {
                w -= items[index].weight;
                maxVal += items[index].value;
            } else {
                double val = ((double) items[index].value / (double) items[index].weight) * (double) w;
                maxVal += val;
                break;
            }
        }
        return Math.round(maxVal * 100.0) / 100.0;
    }
}
