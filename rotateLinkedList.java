import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class rotateLinkedList {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (k == 0)
            return head;
        if (head == null || head.next == null)
            return head;
        int len = 0;
        int index = -1;
        Node dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }

        if (k == len)
            return head;
        index = len - (k % len);
        dummy = head;
        Node prev = null;
        while (index > 0) {
            index--;
            prev = dummy;
            dummy = dummy.next;
        }
        prev.next = null;
        Node curnode = dummy;
        while (dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = head;
        head = curnode;
        return head;
    }
}