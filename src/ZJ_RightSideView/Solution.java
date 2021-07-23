package ZJ_RightSideView;

import GetNext_20210611.Tree;
import Leetcode141_HasCycle.ListNode;

import java.util.*;

/**
 * @Author WangBei
 * @Date 2021/7/23 16:36
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，返回从右侧所能看到的节点值。
 */
public class Solution {
    int[] preorder;
    HashMap<Integer, Integer> hm;

    public List<Integer> rightSideView(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        TreeNode root = rebuildTree(0, 0, preorder.length - 1);
        List list = new ArrayList();
        WFS(root, list);
        return list;
    }

    private void WFS(TreeNode root, List list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == len - 1) list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    private TreeNode rebuildTree(int root, int left, int right) {
        if (left > right || root >= preorder.length) return null;
        int index = hm.get(preorder[root]);
        TreeNode node = new TreeNode(preorder[root], null, null);
        node.left = rebuildTree(root + 1, left, index - 1);
        node.right = rebuildTree(root + index - left + 1, index + 1, right);
        return node;
    }
}
