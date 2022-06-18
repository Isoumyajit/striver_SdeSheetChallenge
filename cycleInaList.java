public class cycleInaList {

    public static boolean detectCycle(Node<Integer> head) {
        // Your code goes here
        if (head == null)
            return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}