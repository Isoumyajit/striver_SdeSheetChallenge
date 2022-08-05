
public class Trie {

    // Initialize your data structure here
    private static trie root = null;

    Trie() {
        // Write your code here
        root = new trie();
    }

    // Inserts a word into the trie

    public static void insert(String word) {
        // Write your code here
        trie newnode = root;
        trie newchar = null;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (newnode.characterlist[word.charAt(i) - 'a'] == null) {
                newchar = new trie();
                newnode.characterlist[word.charAt(i) - 'a'] = newchar;
            }
            newnode = newnode.characterlist[word.charAt(i) - 'a'];
        }
        newnode.isWordend = true;
    }

    // Returns if the word is in the trie

    public static boolean search(String word) {
        // Write your code here
        trie nextnode = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (nextnode.characterlist[word.charAt(i) - 'a'] == null)
                return false;
            else
                nextnode = nextnode.characterlist[word.charAt(i) - 'a'];
        }
        
        if (nextnode.isWordend)
            return true;
        return false;
    }

    // Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        // Write your code here
        trie nextnode = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            if (nextnode.characterlist[prefix.charAt(i) - 'a'] == null)
                return false;
            else
                nextnode = nextnode.characterlist[prefix.charAt(i) - 'a'];
        }
        return true;

    }
}

class trie {
    trie[] characterlist = null;
    boolean isWordend;

    trie() {
        characterlist = new trie[26];
        isWordend = false;
    }
}