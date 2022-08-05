
public class maximumXorofTwonum {

    public static int maximumXor(int[] A) {

        trie_xor root = new trie_xor();
        trie_xor newnode = root;
        for (int i = 0; i < A.length; i++) {
            String num = String.format("%32s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");
            // System.out.println(num);
            newnode = root;
            for (int j = 0; j < num.length(); j++) {

                if (newnode.datas[num.charAt(j) - '0'] == null) {
                    newnode.datas[num.charAt(j) - '0'] = new trie_xor();
                }
                newnode = newnode.datas[num.charAt(j) - '0'];
            }
        }

        newnode = root;
        int maxXor = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            newnode = root;
            int firstnum = A[i];
            int secondnum = 0;

            String num = String.format("%32s", Integer.toBinaryString(A[i]).replaceAll(" ", "0"));
            for (int j = 0, k = 31; j < num.length(); j++, k--) {
                if (num.charAt(j) == '1') {
                    if (newnode.datas[0] != null)
                        newnode = newnode.datas[0];
                    else {
                        secondnum += Math.pow(2, k);
                        newnode = newnode.datas[1];
                    }
                } else {
                    if (newnode.datas[1] != null) {
                        secondnum += Math.pow(2, k);
                        newnode = newnode.datas[1];
                    } else
                        newnode = newnode.datas[0];
                }
            }
            maxXor = Math.max(maxXor, firstnum ^ secondnum);
        }
        return maxXor;
    }
}

class trie_xor {
    boolean isEnd;
    trie_xor[] datas = null;

    trie_xor() {
        this.isEnd = false;
        this.datas = new trie_xor[2];
    }
}