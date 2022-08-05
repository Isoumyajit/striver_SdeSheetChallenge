import java.util.*;

public class TrieII {
    private static trie_ root = null;
    private static Map<String, Integer> hash = null;
    private static Map<trie_, Integer> hashpref = null;

    public TrieII() {
        // Write your code here.
        root = new trie_();
        hash = new HashMap<>();
        hashpref = new HashMap<>();
    }

    public void insert(String word) {
        // Write your code here.
        trie_ newnode = root;
        trie_ newchar = null;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (newnode.characters[word.charAt(i) - 'a'] == null) {
                hashpref.put(newnode, hashpref.getOrDefault(newnode, 0) + 1);
                newchar = new trie_();
                newnode.characters[word.charAt(i) - 'a'] = newchar;
                flag = false;
            } else
                hashpref.put(newnode, hashpref.getOrDefault(newnode, 0) + 1);
            newnode = newnode.characters[word.charAt(i) - 'a'];

        }
        if (flag)
            newnode.count += 1;
        newnode.isWordEnd = true;
        hash.put(word, hash.getOrDefault(word, 0) + 1);

    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        trie_ newnode = root;
        for (int i = 0; i < word.length(); i++) {

            if (newnode.characters[word.charAt(i) - 'a'] == null)
                return 0;
            newnode = newnode.characters[word.charAt(i) - 'a'];
        }
        if (newnode.isWordEnd)
            return hash.get(word);
        return 0;

    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        trie_ newnode = root;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (newnode.characters[word.charAt(i) - 'a'] == null)
                return 0;

            count = hashpref.get(newnode);
            newnode = newnode.characters[word.charAt(i) - 'a'];
        }
        if (newnode.isWordEnd)
            return hash.get(word);
        return count;
    }

    public void erase(String word) {
        trie_ newnode = root;
        // Write your code here.
        if (hash.get(word) == 1) {
            removePath(newnode, word, 0);
            hash.put(word, hash.get(word) - 1);
        } else {
            for (int i = 0; i < word.length(); i++) {
                hashpref.put(newnode, hashpref.get(newnode) - 1);
                newnode = newnode.characters[word.charAt(i) - 'a'];
            }
            hash.put(word, hash.get(word) - 1);
        }
    }

    private static void removePath(trie_ x, String word, int index) {
        if (index == word.length()) {
            return;
        }
        removePath(x.characters[word.charAt(index) - 'a'], word, index + 1);
        hashpref.put(x, hashpref.get(x) - 1);
        if (hashpref.get(x) == 0)
            x.characters[word.charAt(index) - 'a'] = null;
    }
}

class trie_ {
    boolean isWordEnd;
    trie_[] characters = null;
    int count;

    trie_() {
        characters = new trie_[26];
        isWordEnd = false;
        count = 0;
    }
}
