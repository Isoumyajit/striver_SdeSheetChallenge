public class intersectionOfTwoLinkedList {

    public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {

        int len1 = 0, len2 = 0;
        LinkedListNode<Integer> firstHead1 = firstHead;
        LinkedListNode<Integer> second1 = secondHead;
        while (firstHead1 != null) {
            len1++;
            firstHead1 = firstHead1.next;
        }
        while (second1 != null) {
            len2++;
            second1 = second1.next;
        }
        int diff = len1 - len2;
        firstHead1 = firstHead;
        second1 = secondHead;
        if (diff < 0) {
            while (diff++ < 0) {
                second1 = second1.next;
            }
        } else
            while (diff-- > 0) {
                firstHead1 = firstHead1.next;
            }
        while (firstHead1 != null && second1 != null) {
            if (firstHead1 == second1)
                return second1.data;
            firstHead1 = firstHead1.next;
            second1 = second1.next;
        }
        return -1;
    }
}

class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}