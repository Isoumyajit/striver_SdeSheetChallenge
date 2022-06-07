import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class bestTimetoBuyandSell {
    public static int maximumProfit(ArrayList<Integer> prices) {
        // Write your code here.
        Stack<Integer> helper = new Stack<>();
        int len = prices.size();
        int profit = 0;
        int buyingPrice = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            if (helper.isEmpty()) {
                helper.push(prices.get(index));
                buyingPrice = prices.get(index);
            } else {
                // System.out.println("yes"+buyingPrice);
                if (!helper.isEmpty() && helper.peek() < prices.get(index)) {
                    profit = Math.max(profit, prices.get(index) - buyingPrice);
                    helper.push(prices.get(index));
                } else if (!helper.isEmpty() && helper.peek() > prices.get(index)) {
                    while (!helper.isEmpty() && helper.peek() > prices.get(index)) {
                        helper.pop();
                    }
                    helper.push(prices.get(index));
                    if (buyingPrice > prices.get(index))
                        buyingPrice = prices.get(index);
                }
                // System.out.println(helper);
            }
            // System.out.println(buyingPrice);
        }
        // if(!helper.isEmpty() && helper.peek() < buyingPrice){
        // profit = Math.max(profit , helper.peek() - buyingPrice);
        // }
        return profit;
    }
}