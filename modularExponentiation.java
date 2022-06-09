import java.util.*;
import java.io.*;

public class modularExponentiation {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.
        long value = 1;
        long dummy = x;
        for (int power = n; power >= 1;) {
            if (power % 2 == 1) {
                value = (value * (dummy % m)) % m;
                power--;
            } else {
                dummy = ((dummy % m) * (dummy % m)) % m;
                power = power >> 1;
            }
        }
        return (int) (value % m);
    }
}