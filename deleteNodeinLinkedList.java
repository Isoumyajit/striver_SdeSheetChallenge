public class deleteNodeinLinkedList {
    public static void deleteNode(LinkedListNode<Integer> node) {
        // Write your code here.
        LinkedListNode<Integer> temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}