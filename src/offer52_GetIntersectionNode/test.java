package offer52_GetIntersectionNode;

/**
 * @Author WangBei
 * @Date 2021/7/19 17:37
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] listA = {4, 1, 8, 4, 5};
        int[] listB = {5, 0, 1, 8, 4, 5};
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);

        ListNode pre = headA;
        for (int i = 0; i < listA.length; i++) {
            ListNode node = new ListNode(listA[i]);
            pre.next = node;
            pre = pre.next;
        }

        pre = headB;
        for (int i = 0; i < listB.length; i++) {
            ListNode node = new ListNode(listB[i]);
            pre.next = node;
            pre = pre.next;
        }
        ListNode intersectionNode = s.getIntersectionNode(headA.next, headB.next);
        System.out.println(intersectionNode.val);
    }
}
