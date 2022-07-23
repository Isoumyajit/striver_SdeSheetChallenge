import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class maximumuniqueElementineverywindowofk {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

        Set<Integer> helper = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = arr.size();
        ArrayList<Integer> answer = new ArrayList<>();

        while (j < len && i <= len - k) {

            if (j - i + 1 <= k) {
                helper.add(arr.get(j));
                j++;
            } else {
                answer.add(helper.size());
                helper.remove(arr.get(i));
                i++;
                int l = i;
                while (l < j) {
                    if (!helper.contains(arr.get(l)))
                        helper.add(arr.get(l));
                    l++;
                }
            }
        }
        answer.add(helper.size());
        return answer;
    }

    // Using hashMap -- Time Complexity - O(N)
    // Space Complexity -- O(K)
    public static ArrayList<Integer> countDistinct(ArrayList<Integer> arr, int k) {

        Map<Integer, Integer> helper = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = arr.size();
        ArrayList<Integer> answer = new ArrayList<>();

        while (j < len && i <= len - k) {
            if (j - i + 1 <= k) {
                helper.put(arr.get(i), helper.getOrDefault(arr.get(i), 0) + 1);
                j++;
            } else {
                answer.add(helper.size());
                helper.put(arr.get(i), helper.get(arr.get(i)) - 1);
                int frq = helper.get(arr.get(i));
                if (frq == 0)
                    helper.remove(arr.get(i));
                i++;
            }
        }
        answer.add(helper.size());
        return answer;
    }

}
