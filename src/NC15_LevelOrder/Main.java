package NC15_LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author WangBei
 * @Date 2021/8/10 16:07
 * @Description: NC15 求二叉树的层序遍历
 * 描述: 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 示例1
 * 输入：{1,2}
 * 返回值：[[1],[2]]
 * <p>
 * 示例2
 * 输入：{1,2,3,4,#,#,5}
 * 返回值：[[1],[2,3],[4,5]]
 */
public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;


        ArrayList<ArrayList<Integer>> res = levelOrder(null);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here

        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}















