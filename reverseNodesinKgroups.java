public class reverseNodesinKgroups {
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        // Write your code here.
        if (head == null)
            return head;
        Node dummy = new Node(0);
        Node countLen = head;
        int len = 0;
        dummy.next = head;
        Node prev = dummy;
        Node cur = dummy;
        Node next = dummy;
        while (countLen != null) {
            len++;
            countLen = countLen.next;
        }

        for (int index = 0; index < n; index++) {
            int k = b[index];
            if (k == 0)
                continue;
            if (k == 1) {
                cur = prev.next;
                prev.next = cur;
                len -= k;
            }
            if (len < k) {
                k = len;
            }
            cur = prev.next;
            next = cur.next;
            for (int j = 1; j < k; j++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            len -= k;
            if (len <= 0)
                break;
        }
        return dummy.next;
    }
}

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};