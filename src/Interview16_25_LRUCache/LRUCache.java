package Interview16_25_LRUCache;

import NC93_LRU.Solution;

import java.util.HashMap;

/**
 * @Author WangBei
 * @Date 2021/7/21 16:28
 * @Description:
 */
class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node();
    Node tail = new Node();
    int count;
    int k;

    HashMap<Integer, Node> hm = new HashMap<>();

    public LRUCache(int capacity) {
        head.next = tail;
        tail.pre = head;
        count = 0;
        k = capacity;
    }

    public int get(int key) {
        if (hm.get(key) == null) return -1;
        move2Tail(key);
        return hm.get(key).value;
    }

    public void put(int key, int value) {
        if (hm.get(key) == null) {
            if (count >= k) {
                hm.remove(head.next.key);
                removeHead();
            }
            addTail(key, value);
            count++;
        } else {
            hm.get(key).value = value;
            move2Tail(key);
        }
    }

    public void move2Tail(int key) {
        Node node = hm.get(key);

        node.pre.next = node.next;
        node.next.pre = node.pre;

        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public void removeHead() {
        head.next = head.next.next;
        head.next.pre = head;
    }

    public void addTail(int key, int value) {
        Node node = new Node(key, value);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        hm.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */