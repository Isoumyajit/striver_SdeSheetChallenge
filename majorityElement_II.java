import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class majorityElement_II {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        // Write your code here.
        ArrayList<Integer> answer = new ArrayList<>();
        int len = arr.size();
        int num1 = arr.get(0);
        int num2 = 0;
        int count1 = 1;
        int count2 = 0;

        for (int index = 1; index < len; index++) {

            if (num1 == arr.get(index)) {
                count1++;
            } else if (num2 == arr.get(index)) {
                count2++;
            } else {
                if (count1 == 0) {
                    num1 = arr.get(index);
                    count1 = 1;
                } else if (count2 == 0) {
                    num2 = arr.get(index);
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        int countA = 0;
        int countB = 0;
        for (int index = 0; index < len; index++) {
            if (arr.get(index) == num1) {
                countA++;
            }
            if (arr.get(index) == num2) {
                countB++;
            }
        }
        if (countA > len / 3)
            answer.add(num1);
        if (countB > len / 3)
            answer.add(num2);
        return answer;
    }
}