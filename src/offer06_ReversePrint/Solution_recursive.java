package offer06_ReversePrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/6/9 11:15
 */
/*
题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]
限制：
    0 <= 链表长度 <= 10000
*/
// 递归解法
public class Solution_recursive {
    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void recur(ListNode node) {
        if (node == null) return;
        recur(node.next);
        list.add(node.val);
    }
}
