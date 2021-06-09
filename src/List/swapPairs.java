package List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode front = new ListNode();
        // ListNode rear = new ListNode();
        front = head;
        // rear = head.next;
        while(front != null && front.next != null){
            ListNode node = new ListNode();
            System.out.print(front.val);
            System.out.println(front.next.val);
            node = front;
            front = front.next;
            System.out.println("node:"+node.val);
            node.next = front.next;
            front.next = node;
            System.out.println("previous:"+front.val+front.next.val);
            if (front.next.next == null){
                return head;
            }
            front = front.next.next;

            // System.out.println(front.val);
            // while(head!=null){
            //     System.out.print(head.val);
            //     head = head.next;
            // }
            // System.out.println();
        }
        return head;
    }

    public void swapPairs() {
    }
}

public class swapPairs {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = 1;
        ListNode head = new ListNode();
        ListNode N = new ListNode();
        N = head;
        for(i=1; i<5; i++){
            ListNode node = new ListNode();
            node.val = i;
            node.next = null;
            N = node;
            N = N.next;
        }

        s.swapPairs();
    }
}
