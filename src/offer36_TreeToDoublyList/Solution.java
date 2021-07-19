package offer36_TreeToDoublyList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/19 10:19
 * @Description: 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Solution {
    Node pre, head;         // 当前遍历到指针的前驱指针以及整个链表的头指针（树最左边的叶子）

    public Node treeToDoublyList(Node root) {
        // 所有节点的后驱节点都等于当前树节点的右子树左下角的节点，前驱节点等于左子树的右下角的节点
        if (root == null) return null;
        head = root;        // 当前需要修改前驱指针的节点
        DFS(head);
        head.left = pre;    // 将链表的头尾相连
        pre.right = head;
        return head;
    }

    public void DFS(Node cur) {
        if (cur == null) return;

        DFS(cur.left);      // 遍历左子树

        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;

        DFS(cur.right);     // 遍历右子树
    }
}
/**
 * 思路：中序遍历
 * 中序遍历二叉树，并在每次遍历到节点时将他的前驱和后继指针进行修改。
 */