public class atoi {
    public static int aToi(String str) {
        // Write your code here.
        long answer = 0;

        for (char a : str.toCharArray()) {

            if (a >= 48 && a <= 57) {
                answer = answer * 10 + (a - '0');
            }
        }
        if (str.charAt(0) == '-')
            answer *= -1;
        return (int) answer;
    }
}
