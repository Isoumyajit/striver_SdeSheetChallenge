public class flatternLinkedList {
    public static Node flattenLinkedList(Node head) {
        // Write your code here
        if (head == null || head.next == null)
            return head;
        head.next = flattenLinkedList(head.next);
        head = merge(head, head.next);
        return head;
    }

    public static Node merge(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.child = a;
                temp = temp.child;
                a = a.child;
            } else {
                temp.child = b;
                temp = temp.child;
                b = b.child;
            }
        }

        if (a != null)
            temp.child = a;
        else
            temp.child = b;
        return res.child;
    }
}

class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}