import java.util.*;
import java.io.*;

class LinkedListNode<Integer> {
    Integer data;
    LinkedListNode<Integer> next;

    public LinkedListNode(Integer data) {
        this.data = data;
    }
}

public class mergesortedLinkedList {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Write your code here.
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> one = first;
        LinkedListNode<Integer> two = second;
        LinkedListNode<Integer> dummy = null;

        while (one != null && two != null) {
            if (one.data < two.data) {
                if (head == null) {
                    head = new LinkedListNode(one.data);
                    dummy = head;
                } else {
                    LinkedListNode<Integer> newnode = new LinkedListNode(one.data);
                    dummy.next = newnode;
                    dummy = dummy.next;
                }
                one = one.next;
            } else {
                if (head == null) {
                    head = new LinkedListNode(two.data);
                    dummy = head;
                } else {
                    dummy.next = new LinkedListNode(two.data);
                    dummy = dummy.next;
                }
                two = two.next;
            }
        }
        while (one != null) {
            if (head == null) {
                head = new LinkedListNode(one.data);
                dummy = head;
            } else {
                dummy.next = new LinkedListNode(one.data);
                dummy = dummy.next;
            }
            one = one.next;
        }
        while (two != null) {
            if (head == null) {
                head = new LinkedListNode(two.data);
                dummy = head;
            } else {
                dummy.next = new LinkedListNode(two.data);
                dummy = dummy.next;
            }
            two = two.next;
        }
        return head;
    }
}
