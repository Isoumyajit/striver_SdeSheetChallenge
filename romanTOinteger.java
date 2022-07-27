public class romanTOinteger {
    public static int romanToInt(String s) {
        // Write your code here
        String answer = "";
        int prev = 0;
        for (int index = s.length() - 1; index >= 0; index--) {
            int val = getValue(s.charAt(index));

            if (answer.length() == 0) {
                answer += val;
                prev = val;
            }

            else if (prev > val) {
                answer = String.valueOf(Integer.parseInt(answer) - val);
                prev = val;
            } else {
                answer = String.valueOf(Integer.parseInt(answer) + val);
                prev = val;
            }
        }
        return Integer.parseInt(answer);
    }

    private static int getValue(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

}