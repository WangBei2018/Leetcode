package Leetcode141_HasCycle;

/**
 * @Author WangBei
 * @Date 2021/7/23 11:28
 * @Description:
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != slow && fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == slow) {
            ListNode node = head;
            while (node != fast) {
                node = node.next;
                fast = fast.next;
            }
            return node;
        }
        return null;
    }
}
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode slow = head, fast = head;
//        while (fast != null) {
//            slow = slow.next;
//            if (fast.next != null) {
//                fast = fast.next.next;
//            } else {
//                return null;
//            }
//            if (fast == slow) {
//                ListNode ptr = head;
//                while (ptr != slow) {
//                    ptr = ptr.next;
//                    slow = slow.next;
//                }
//                return ptr;
//            }
//        }
//        return null;
//    }
//}
