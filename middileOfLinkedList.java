import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class middileOfLinkedList {
    public static Node findMiddle(Node head) {
        // Write your code here
        int len = 0;
        Node dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }
        dummy = head;
        int count = 1;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
            if (count == len / 2 + 1)
                return dummy;
        }
        return head;
    }
}
