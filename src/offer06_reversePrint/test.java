package offer06_reversePrint;

import offer05_replaceSpace.Solution;

/**
 * @Author WangBei
 * @Date 2021/6/9 11:18
 */
public class test {
    public static void main(String[] args) {
        int[] headList = {1, 3, 2};
        ListNode head = new ListNode(0);
        ListNode nextnode = head;

        for (int i = 0; i < headList.length; i++) {
            ListNode node = new ListNode(headList[i]);
            nextnode.next = node;
            nextnode = nextnode.next;
        }

        ListNode ln = head.next;
        while (ln.next != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }


//        Solution_stack ss = new Solution_stack();
//        ss.reversePrint(head);
//
//        Solution_recursive sr = new Solution_recursive();
//        sr.reversePrint(head);
    }
}
