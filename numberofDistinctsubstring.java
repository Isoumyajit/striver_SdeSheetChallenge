
public class numberofDistinctsubstring {
    public static int distinctSubstring(String word) {

        trie_ root = new trie_();
        trie_ newnode = root;

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            newnode = root;
            for (int j = i; j < word.length(); j++) {
                if (newnode.datas[word.charAt(j) - 'a'] == null) {
                    newnode.datas[word.charAt(j) - 'a'] = new trie_();
                    count++;
                }
                newnode = newnode.datas[word.charAt(j) - 'a'];
            }
        }
        return count;
    }
}

class trie_ {
    trie_[] datas = null;

    trie_() {
        datas = new trie_[26];
    }
}