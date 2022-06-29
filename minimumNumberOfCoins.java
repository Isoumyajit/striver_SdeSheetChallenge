public class minimumNumberOfCoins {
    public static int findMinimumCoins(int amount) {
        // Write your code here.
        if (amount == 0)
            return 0;
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10 || amount == 20 || amount == 50 || amount == 100
                || amount == 500 || amount == 1000)
            return 1;

        int count = 0;
        int[] money = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        for (int index = 8; index >= 0;) {
            if (amount >= money[index]) {
                amount -= money[index];
                count++;
            }
            if (amount == 0)
                break;
            if (amount < money[index])
                index--;

        }
        return count;
    }
}
