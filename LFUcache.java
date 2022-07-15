import java.util.HashMap;
import java.util.Map;

public class LFUcache {

    static Map<Integer, Nodes> helper = null;
    static Map<Integer, LRUcache> frq = null;
    Nodes start = null;
    Nodes end = null;
    int size = 0;
    int capacity = 0;

    LFUcache(int capacity) {
        // Write your code here.
        this.capacity = capacity;
        frq = new HashMap<>();
        helper = new HashMap<>();
        start = new Nodes();
        end = new Nodes();
        start.next = end;
        end.prev = start;
    }

    int get(int key) {
        // Write your code here.
        return 0;
    }

    void put(int key, int value) {
        // Write your code here.
        Nodes node = new Nodes(key, value);
        if (helper.containsKey(key)) {
            Nodes exist = helper.get(key);
            exist.frquency += 1;
            if (frq.containsKey(exist.frquency)) {
                LRUcache temp = frq.get(exist.frquency);
                temp.removeLast(exist);
                temp.addFront(exist);
            }
        } else {
            if (size < capacity) {

            } else {

            }
        }

    }
}

class LRUcache {

    Nodes start = null;
    Nodes end = null;
    int size;

    LRUcache() {
        start = new Nodes();
        end = new Nodes();
        start.next = end;
        end.prev = start;
        size = 0;
    }

    int get(int key) {

        removeLast();
        return 0;
    }

    void put(int key, int value) {
        Nodes node = new Nodes(key, value);
        addFront(node);
    }

    void addFront(Nodes node) {
        node.next = start.next;
        node.prev = start;
        node.next.prev = node;
        start.next = node;
        size++;
    }

    void removeLast(Nodes key) {
        key.prev.next = key.next.prev;
        size--;
    }
}

class Nodes {
    int data;
    int key;
    int frquency;
    Nodes next;
    Nodes prev;

    Nodes() {
        this.next = null;
        this.prev = null;
    }

    Nodes(int key, int data) {
        this.data = data;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}
