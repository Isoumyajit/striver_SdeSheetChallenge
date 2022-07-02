import java.util.ArrayList;

public class kthPermutation {
    public static String kthPermutation(int n, int k) {
        // Write your code here.

        if (n == 1 && k == 1)
            return "1";
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int index = 1; index < n; index++) {
            fact = fact * index;
            nums.add(index);
        }
        nums.add(n);
        String answer = "";
        k--;
        while (true) {
            answer += nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.size() == 0)
                break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return answer;
    }

}