package Leetcode141_HasCycle;

/**
 * @Author WangBei
 * @Date 2021/7/23 11:28
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(0);
        createList(head);
        System.out.println(s.detectCycle(head.next).val);
    }

    public static void createList(ListNode head) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

    }
}
