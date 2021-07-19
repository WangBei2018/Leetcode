package offer36_TreeToDoublyList;

/**
 * @Author WangBei
 * @Date 2021/7/19 10:19
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node root = new Node();
        createTRee(root);

        Node head = s.treeToDoublyList(root);
    }

    public static void createTRee(Node root) {

        root.val = 4;
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;
    }
}
