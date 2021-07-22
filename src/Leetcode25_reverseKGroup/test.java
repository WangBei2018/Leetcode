package Leetcode25_reverseKGroup;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:57
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode();
        createList(arr, head);
        int k = 2;
        ListNode headNode = s.reverseKGroup(head.next, k);
        while (headNode != null) {
            System.out.print(headNode.val + " ");
            headNode = headNode.next;
        }
    }

    public static void createList(int[] arr, ListNode head) {
        ListNode pre = head;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            pre.next = node;
            pre = node;
        }
    }
}
