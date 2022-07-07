import java.util.ArrayList;

public class wordBreakII {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // Write your code here.
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        makeSentence(s, words, dictionary, answer, 0, s.length());
        // System.out.println(answer);
        return answer;
    }

    public static void makeSentence(String s, ArrayList<String> words, ArrayList<String> dic, ArrayList<String> answer,
            int index, int len) {

        if (index == len) {
            String sen = "";
            for (String x : words) {
                sen += x;
                sen += " ";
            }
            answer.add(sen.trim());
            return;
        }

        String word = "";
        for (int i = index; i < len; i++) {
            word += s.charAt(i);
            if (dic.contains(word)) {
                words.add(word);
                makeSentence(s, words, dic, answer, i + 1, len);
                words.remove(words.size() - 1);
            }
        }
    }
}