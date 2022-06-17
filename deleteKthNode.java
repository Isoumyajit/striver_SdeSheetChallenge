class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class deleteKthNode {
    public static LinkedListNode removeKthNode(LinkedListNode head, int K) {
        // Write your code here
        if (head == null)
            return head;
        int len = 0;
        LinkedListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        int index = len - K;
        int curInd = 0;
        if (index == len - 1) {

        }
        if (index == 0) {
            head = head.next;
            return head;
        }
        dummy = head;
        LinkedListNode prev = head;
        while (curInd < index && dummy != null) {
            curInd++;
            prev = dummy;
            dummy = dummy.next;
        }
        if (dummy == null) {
            prev.next = null;
            return head;
        }
        prev.next = dummy.next;
        return head;
    }
}
