import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Approach - 1 TC - We was having an overhead of checking duplicates O(nLOGn) + O(N) + 
//Approach - 2 TC - O(nLOGn) + O(2 ^ n) || SC - O(2 ^ n ) * O(K) 

public class subSets_II {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        // Write your code here..
        int n = arr.length;

        List<List<Integer>> answer = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (n == 0) {
            answer.add(temp);
            return answer;
        }
        // Arrays.sort(arr);
        createSubset(arr, temp, answer, 0, n);

        return answer;
    }

    public static void createSubset(int[] arr, ArrayList<Integer> helper, List<List<Integer>> answer, int index,
            int n) {

        if (n == index) {
            ArrayList<Integer> temp = new ArrayList<>(helper);
            Collections.sort(temp);
            if (!answer.contains(temp))
                answer.add(temp);
            return;
        }
        helper.add(arr[index]);
        createSubset(arr, helper, answer, index + 1, n);
        helper.remove(helper.size() - 1);
        createSubset(arr, helper, answer, index + 1, n);
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (n == 0) {
            answer.add(temp);
            return answer;
        }
        Arrays.sort(arr);
        createSubset(arr, temp, answer, 0, n);

        return answer;
    }

    public static void createSubset(int[] arr, ArrayList<Integer> helper, ArrayList<ArrayList<Integer>> answer,
            int index, int n) {

        ArrayList<Integer> dummy = new ArrayList<>(helper);
        answer.add(dummy);
        for (int curindex = index; curindex < n; curindex++) {
            if ((curindex == index || arr[curindex] != arr[curindex - 1])) {
                helper.add(arr[curindex]);
                createSubset(arr, helper, answer, curindex + 1, n);
                helper.remove(helper.size() - 1);
            }
        }
    }
}
