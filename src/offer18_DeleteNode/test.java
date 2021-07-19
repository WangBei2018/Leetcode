package offer18_DeleteNode;

import java.security.cert.CRLException;

/**
 * @Author WangBei
 * @Date 2021/7/19 9:54
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(0);
        createList(head);
        int val = 4;
        ListNode del = s.deleteNode(head.next, val);
        while (del != null) {
            System.out.println(del.val);
            del = del.next;
        }
    }

    public static void createList(ListNode head) {
        int[] list = {4, 5, 1, 9};
        ListNode pre = head;
        for (int i = 0; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            node.next = null;
            pre.next = node;
            pre = node;
        }
    }

}
