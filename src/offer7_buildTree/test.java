package offer7_buildTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author WangBei
 * @Date 2021/6/10 9:03
 */
public class test {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution s = new Solution();
        TreeNode tn = s.buildTree(preorder, inorder);

        WFS(tn);
    }

    public static void WFS(TreeNode tn) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tn);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        for (int i : list) {
            System.out.print(i + " ");
        }

    }
}
