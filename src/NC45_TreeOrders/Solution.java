package NC45_TreeOrders;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/8/10 15:49
 * @Description: NC45 实现二叉树先序，中序和后序遍历
 * 描述:分别按照二叉树先序，中序和后序打印所有的节点。
 * <p>
 * 示例1
 * 输入： {1,2,3}
 * 返回值： [[1,2,3],[2,1,3],[2,3,1]]
 * 备注： n ≤ 10^6
 */
public class Solution {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        // write code here

        preOrder(root);
        inOrder(root);
        postOrder(root);
        int[][] res = new int[3][pre.size()];
        for (int j = 0; j < pre.size(); j++) {
            res[0][j] = pre.get(j);
        }
        for (int j = 0; j < pre.size(); j++) {
            res[1][j] = in.get(j);
        }
        for (int j = 0; j < pre.size(); j++) {
            res[2][j] = post.get(j);
        }
        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }

}

