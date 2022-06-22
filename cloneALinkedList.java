import java.util.*;
import java.io.*;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    LinkedListNode<T> random;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class cloneALinkedList {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
        // Write your code here.

        LinkedListNode<Integer> head1 = null;
        LinkedListNode<Integer> dummy = head;
        LinkedListNode<Integer> newlist = null;
        if (head == null)
            return newlist;
        while (dummy != null) {
            LinkedListNode<Integer> newnode = new LinkedListNode<>(dummy.data);
            newnode.next = dummy.next;
            dummy.next = newnode;
            dummy = newnode.next;
        }
        dummy = head;
        newlist = dummy.next;
        while (dummy != null) {
            LinkedListNode<Integer> copynode = dummy.next;
            LinkedListNode<Integer> random = dummy.random;
            LinkedListNode<Integer> next = copynode.next;
            if (random != null)
                copynode.random = random.next;
            else
                copynode.random = null;
            if (next != null)
                copynode.next = next.next;
            else
                copynode.next = null;
            dummy = next;
        }
        dummy = head;
        while (dummy != null && dummy.next != null) {
            dummy.next = dummy.next.next;
            dummy = dummy.next;
        }
        return newlist;
    }
}
