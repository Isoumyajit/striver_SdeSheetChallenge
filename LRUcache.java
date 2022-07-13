import java.util.*;

public class LRUcache {
    Map<Integer, Node> hash = null;
    Node dll_head = null;
    Node dll_tail = null;
    int capacity = 0;
    int count = 0;

    LRUcache(int capacity) {
        // Write your code here
        hash = new HashMap<>();
        dll_head = new Node();
        dll_tail = new Node();
        dll_head.next = dll_tail;
        dll_tail.prev = dll_head;
        this.capacity = capacity;
    }

    public int get(int key) {
        // Write your code here
        int num = -1;
        if (hash.containsKey(key)) {
            num = hash.get(key).data;
            put(key, num);
        }
        return num;
    }

    public void put(int key, int value) {

        // System.out.println(hash);
        // Write your code here
        Node newnode = new Node(value, key);
        if (!hash.containsKey(key) && hash.size() < this.capacity) {
            hash.put(key, newnode);
            newnode.next = dll_head.next;
            newnode.prev = dll_head;
            newnode.next.prev = newnode;
            dll_head.next = newnode;
        } else if (hash.containsKey(key)) {
            Node exist = new Node(value, key);
            Node exnode = hash.get(key);
            hash.remove(key);
            hash.put(key, exist);
            exist.data = value;
            exnode.prev.next = exnode.next;
            exnode.next.prev = exnode.prev;
            exist.next = dll_head.next;
            exist.prev = dll_head;
            exist.next.prev = exist;
            dll_head.next = exist;
        } else {

            hash.remove(dll_tail.prev.key);
            dll_tail.prev = dll_tail.prev.prev;
            if (dll_tail.prev != null)
                dll_tail.prev.next = dll_tail;
            newnode.next = dll_head.next;
            newnode.prev = dll_head;
            newnode.next.prev = newnode;
            dll_head.next = newnode;
            hash.put(key, newnode);
        }
    }
}

class Node {
    Node next;
    Node prev;
    int data;
    int key;

    Node() {
        next = null;
        prev = null;
    }

    Node(int data, int key) {
        next = null;
        prev = null;
        this.data = data;
        this.key = key;
    }
}