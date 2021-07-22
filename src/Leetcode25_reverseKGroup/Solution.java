package Leetcode25_reverseKGroup;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:57
 * @Description:
 */

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return new ListNode();
        if (k == 1) return head;
        ListNode subHead = head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode subPre = new ListNode();
        subPre.next = head;
        int count = 0;
        while (judge(subHead, k)) {             // 判断是否还存在带反转的子链表，如果存在则翻转，否则，返回头结点
            for (int i = 1; i < k; i++) {
                pre.next = cur.next;
                cur.next = subHead;
                subHead = cur;
                cur = pre.next;
            }
            // 在第一个子链表处，需要将整个链表的头结点指向子链表的头部，否则第一个子链表最终只存在一个节点。后面的子链表有subHead来讲子链表相连
            if (count == 0) head = subHead;
            subPre.next = subHead;
            subHead = cur;
            subPre = pre;
            pre = cur;
            if (pre == null) break;             // 当整个链表证号所有的节点都被翻转时，下一个“子链表”为空，则不会存在pre.next，会出现空指针异常。
            cur = pre.next;
            count++;                            // 只有在第一次循环时才有用，为了纠正头结点
        }
        return head;
    }

    private boolean judge(ListNode subHead, int k) {
        int count = 0;
        ListNode node = subHead;
        while (node != null) {
            count++;
            if (count == k) break;
            node = node.next;
        }
        if (count == k) return true;
        return false;
    }
}
/**
 * 思路：
 * 额外的变量：除了头指针以外，需要的指针有：（1）当前待交换节点指针cur，（2）前一个指针pre，（3）子链表头指针（4）上一个子链表的尾之后怎
 * 步骤：
 * ···1、判断带翻转链表的长度是否还大于等于k，大于等于k时，才能翻转，否则翻转任务结束
 * ···2、对子链表进行翻转，从子链表的第二个节点开始，依次放在子链表头 subHead 的位置，子链表翻转完毕之后，将当前翻转完成的子链表与前一个子链表相连，更新各个指针所指向的位置
 * ···3、最后返回头指针。
 */