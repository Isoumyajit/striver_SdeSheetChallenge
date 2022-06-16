import java.util.*;
import java.io.*;

//Following is the structure of the Singly Linked List.	
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class linkedListReverse {
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        // Write your code here!
        LinkedListNode dummy = head;
        LinkedListNode prev = null;
        LinkedListNode next = null;

        while (dummy != null) {
            next = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = next;
        }
        return head;
    }
}