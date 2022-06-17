class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class addTwoNumbersAsLinkedList {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy = null;
        LinkedListNode l1 = head1;
        LinkedListNode l2 = head2;
        LinkedListNode helper = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry >= 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            LinkedListNode temp = new LinkedListNode(sum % 10);
            if (dummy == null) {
                dummy = temp;
                helper = dummy;
            } else {
                helper.next = temp;
                helper = helper.next;
            }
        }
        return dummy;
    }
}
