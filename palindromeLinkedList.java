public class palindromeLinkedList {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        // Write your code here!
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        // if(head.next.next == null){
        // if(head.data == head.next.data)return true;
        // else return false;
        // }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        fast = head;
        slow = slow.next;
        while (slow != null) {
            if (!slow.data.equals(fast.data))
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> dummy = head;
        LinkedListNode<Integer> next = head;

        while (dummy != null) {
            next = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = next;
        }
        return prev;
    }
}