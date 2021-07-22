package NC93_LRU;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/21 10:25
 * @Description:
 */
public class Solution {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    HashMap<Integer, Node> hm = new HashMap<>();
    int count = 0;
    Node head;
    Node tail;
    int k;

    class Node {        // 链表节点
        int key, val;
        Node pre, next;

        Node() {
        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int[] LRU(int[][] operators, int k) {
        // write code here
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.k = k;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {        // 遍历二维数组
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            }
            if (operators[i][0] == 2) {
                int val = get(operators[i][1]);
                res.add(val);
            }
        }

        int[] resList = new int[res.size()];            // 将ArrayList转为int[]数组
        for (int i = 0; i < res.size(); i++) {
            resList[i] = res.get(i);
        }
        return resList;
    }

    public int get(int key) {
        if (hm.get(key) == null) return -1;         // 没有当前记录
        move2Tail(key);                             // 有当前记录，将当前记录移至链表尾部，并返回value
        return hm.get(key).val;
    }

    public void set(int key, int value) {
        if (hm.get(key) == null) {          // 有可能当前添加的key在HashMap中本来就存在，支序修改原来的值并将链表中的node移到尾部
            if (count >= k) {               // 超出缓存容量，移除链表头部节点和它对应的HashMap中的记录
                hm.remove(head.next.key);
                removeHead();
            }
            addTail(key, value);
            count++;                        // 缓存当前容量+1
        } else {
            hm.get(key).val = value;        // 原始HashMap中有这个key，修改value值和链表中的位置
            move2Tail(key);
        }
    }

    public void move2Tail(int key) {                 // get方法后，将最常使用的节点放在链表的最后端
        Node node = hm.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public void removeHead() {                      // 缓存容量超过最大容量时，添加记录要将链表中头结点指向的节点删除
        head.next = head.next.next;
        head.next.pre = head;
    }

    public void addTail(int key, int value) {       // 添加新记录时，向链表喂不添加新节点，并在HashMap中添加记录
        Node node = new Node(key, value);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        hm.put(key, node);
    }
}
/**
 * 思路：HashMap + 双向链表（头部指向最不经常使用的记录，尾部是最近最长访问的记录）
 * 1、HashMap 的 key 存储 记录中的 key 值，value 值存储一个 Node 对象，为了每次判断是否存在当前添加或查询的记录，比那个可以找到它对应在链表中的位置
 * 2、其中 Node 有 key 和 value 两个变量，还有 pre 和 next 两个指针
 * 3、遍历整个输入的二维数组，判断第一维的值，然后进行 set 和 get
 * ···3.1 get时，判断当前的HashMap中是否存在，不存在返回-1；存在返回key对应的value，并将key对应的节点移到链表尾部
 * ···3.2 set时，判断当前key是否存在HashMap中，
 * ······3.2.1 存在的话只需要修改链表节点对应的value并将节点移到尾部；
 * ······3.2.2 不存在的话，判断是否超过缓存的最大容量，
 * ···········（1）超过的话，移除HashMap和链表中头结点指向的记录，并将新天街的节点介入HashMap和链表尾部
 * ···········（2）没超过的话，构建节点并添加到链表尾部，HashMap添加这条记录
 */