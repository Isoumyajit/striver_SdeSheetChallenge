public class implementQueue {

    Node head = null;
    Node last = null;

    implementQueue() {
        // Implement the Constructor
        head = new Node();
        last = new Node();
        head.next = last;
        last.prev = head;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if (head.next == last)
            return true;
        else
            return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        Node newnode = new Node(data);
        newnode.prev = last.prev;
        last.prev = newnode;
        newnode.prev.next = newnode;
        newnode.next = last;
    }

    int dequeue() {
        // Implement the dequeue() function
        if (head.next == last)
            return -1;
        int data = head.next.data;
        head.next.next.prev = head;
        head.next = head.next.next;
        return data;
    }

    int front() {
        // Implement the front() function
        if (head.next == last)
            return -1;
        return head.next.data;
    }

}

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node() {
        this.next = null;
        this.prev = null;
    }
}