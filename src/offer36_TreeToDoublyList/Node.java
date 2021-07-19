package offer36_TreeToDoublyList;

/**
 * @Author WangBei
 * @Date 2021/7/19 10:19
 * @Description:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
