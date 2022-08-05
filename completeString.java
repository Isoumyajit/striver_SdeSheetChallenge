import java.util.*;

public class completeString {

    public static String completeString_(int n, String[] a) {
        Arrays.sort(a, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        trie_ root = new trie_();
        trie_ newnode = root;
        String answer = "";
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            int count = 0;
            newnode = root;
            char d = 'a';
            trie_ temp = new trie_();
            boolean flag = false;
            // System.out.println(s+" ");
            for (char x : s.toCharArray()) {
                if (newnode.data[x - 'a'] == null) {
                    newnode.data[x - 'a'] = new trie_();
                    if (!flag) {
                        temp = newnode;
                        d = x;
                        flag = true;
                    }
                } else
                    count++;
                newnode = newnode.data[x - 'a'];
            }
            if (count + 1 == s.length() && s.length() >= len) {
                if (len == s.length() && (answer.compareTo(s) > 0 || answer.compareTo(s) == -1)) {
                    answer = s;
                    len = s.length();
                } else if (s.length() > len) {
                    answer = s;
                    len = s.length();
                }
            } else
                temp.data[d - 'a'] = null;
        }
        if (answer == "")
            return "None";
        return answer;
    }
}

class trie_ {
    trie_[] data = null;

    trie_() {
        this.data = new trie_[26];
    }
}