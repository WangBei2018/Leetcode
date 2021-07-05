package offer06_ReversePrint;

import java.util.LinkedList;

/**
 * @Author WangBei
 * @Date 2021/6/9 11:13
 */

/*
题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]
限制：
    0 <= 链表长度 <= 10000
*/

// 辅助栈求解
public class Solution_stack {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.offerLast(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int i = 0;
        while (!list.isEmpty()) {
            res[i] = list.pollLast();
            i++;
        }

        return res;
    }
}
