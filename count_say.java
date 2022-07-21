public class count_say {
    public static String writeAsYouSpeak(int n) {
        // Write your code here.
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        else if (n == 3)
            return "21";
        else if (n == 4)
            return "1211";

        String temp = writeAsYouSpeak(n - 1);
        StringBuffer answer = new StringBuffer();
        int start = 0;
        int end = 0;
        boolean flag = true;
        while (start < temp.length() && end < temp.length()) {
            if (flag && temp.charAt(end) != temp.charAt(start)) {
                answer.append(end - start);
                answer.append(temp.charAt(start));
                flag = false;
            } else if (temp.charAt(start) == temp.charAt(end)) {
                flag = true;
                end++;
            } else
                start++;
        }
        if (flag) {
            answer.append(end - start);
            answer.append(temp.charAt(start));
        }
        StringBuffer s = new StringBuffer();

        return answer.toString();
    }
}