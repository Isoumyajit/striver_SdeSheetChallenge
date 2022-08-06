import java.util.*;

public class longestCommonPrefix {
    public static String longestCommonPrefix__(String[] arr, int n) {
        _trie_ root = new _trie_();
        _trie_ newnode = root;

        Map<_trie_, ArrayList<Integer>> helper = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            newnode = root;
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (newnode.data[s.charAt(j) - 'a'] == null) {
                    newnode.data[s.charAt(j) - 'a'] = new _trie_();
                    if (!helper.containsKey(newnode)) {
                        helper.put(newnode, new ArrayList<>());
                        helper.get(newnode).add(s.charAt(j) - 'a');
                    } else {
                        helper.get(newnode).add(s.charAt(j) - 'a');
                    }
                    // System.out.println(helper);
                }
                if (helper.get(newnode).size() > 1) {
                    flag = false;
                    break;
                }
                if (!flag)
                    break;
                newnode = newnode.data[s.charAt(j) - 'a'];
            }
        }

        newnode = root;
        String answer = "";
        while (newnode != null) {
            int size = (helper.get(newnode) != null) ? helper.get(newnode).size() : 0;
            if (size == 1) {
                int index = helper.get(newnode).get(0);
                answer += (char) (index + 'a');
                newnode = newnode.data[index];
            } else
                return answer;
        }
        return answer;
    }
}

class _trie_ {
    _trie_[] data = null;

    _trie_() {
        data = new _trie_[26];
    }
}
