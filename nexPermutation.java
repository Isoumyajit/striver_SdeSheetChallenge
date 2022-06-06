import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class nexPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        // Write your code here.
        int len = permutation.size();
        if (len == 1)
            return permutation;
        int lastIndex = -1;
        for (int index = 1; index < len; index++) {
            if (permutation.get(index) > permutation.get(index - 1)) {
                lastIndex = index;
            }
        }
        // System.out.println(lastIndex);
        if (lastIndex == -1) {
            for (int index = 0; index < len / 2; index++) {
                int a = permutation.get(index);
                int b = permutation.get(len - index - 1);
                a += b;
                b = a - b;
                a = a - b;
                permutation.set(index, a);
                permutation.set(len - index - 1, b);
            }
            return permutation;
        } else {
            int indexdummy = lastIndex;
            for (int index = lastIndex + 1; index < len; index++) {
                if (permutation.get(indexdummy - 1) < permutation.get(index)) {
                    lastIndex = index;
                }
            }
            int a = permutation.get(indexdummy - 1);
            int b = permutation.get(lastIndex);
            a = a + b;
            b = a - b;
            a = a - b;
            permutation.set(indexdummy - 1, a);
            permutation.set(lastIndex, b);
            // System.out.println(indexdummy);
            for (int index = indexdummy, right = len - 1; index < right; index++, right--) {
                a = permutation.get(index);
                b = permutation.get(right);
                a += b;
                b = a - b;
                a = a - b;
                permutation.set(index, a);
                permutation.set(right, b);
            }
        }
        return permutation;
    }
}
