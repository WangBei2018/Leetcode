package offer18_DeleteNode;

/**
 * @Author WangBei
 * @Date 2021/7/19 9:54
 * @Description: 题目：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * ···输入: head = [4,5,1,9], val = 5
 * ···输出: [4,1,9]
 * ···解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * ···输入: head = [4,5,1,9], val = 1
 * ···输出: [4,5,9]
 * ···解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * ···题目保证链表中节点的值互不相同
 * ···若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode del = new ListNode(0);
        ListNode pre = new ListNode(0);
        pre = head;
        del = pre.next;
        while (del != null) {
            if (del.val == val) {
                pre.next = del.next;
                break;
            }
            pre = pre.next;
            del = del.next;
        }
        return head;
    }
}
/**
 * 思路：双指针，一个指向当前判断的节点del，一个指向上一个节点pre。
 * 1. 判断头结点的值如果等于val，则直接返回head.next
 * 2. 判断当前节点的值是否等于val，若不等于则pre和del都指向下一个节点；若等于则将pre.next指向del.next。最后返回head即可
 */