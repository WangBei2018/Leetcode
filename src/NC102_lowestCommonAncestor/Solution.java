package NC102_lowestCommonAncestor;

/**
 * @Author WangBei
 * @Date 2021/7/24 10:58
 * @Description: NC102 在二叉树中找到两个节点的最近公共祖先 ---- offer68
 * 描述
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 注：本题保证二叉树中每个节点的val值均不相同。
 * <p>
 * 示例1
 * 输入：[3,5,1,6,2,0,8,#,#,7,4],5,1
 * 返回值：3
 */
public class Solution {
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null) return -1;
        if (o1 == o2) return o1;
        int parent = 0;
        TreeNode dfs = DFS(root, o1, o2);
        parent = dfs.val;

        return parent;
    }

    public TreeNode DFS(TreeNode root, int o1, int o2) {
        if (root == null) return null;
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = DFS(root.left, o1, o2);
        TreeNode right = DFS(root.right, o1, o2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
/**
 * 思路：深度遍历
 * 分析：最近公共祖先，两种情况
 * （1）两个节点在公共祖先的左右两侧，此时 left 和 right 分别指向 o1 和 o2 所对应的节点。
 * （2）两个节点在公共祖先的同侧，此时两个节点中的一个节点是公共祖先，此时 left 或 right 其中之一为 null。并且在深度遍历时遍历到公共父节点时直接返回公共父节点，不会遍历到子节点。
 * 所以只需找到值为 o1 和 o2 的节点，逐层返回，判断当前层的 left 和 right 指针。
 * 步骤：
 * 1. 找到节点的值等于 o1 或 o2 时，返回当前节点，
 * 2.
 * 2.1. 如果当前节点的 left == null 时，证明当前节点的左子树中不存在要查找的节点，返回右节点；
 * 2.2. 如果当前节点 right == null 证明当前节点的右节点不存在要查找的节点，返回左节点；
 * 2.3. 如果当前节点左右节点都不为空的话，返回当前节点，即要查找的节点。
 * 前两种情况可能是两个节点处于公共父节点两侧，找到其中一个节点；也可能是两个节点是父子关系，只找到父节点就直接返回。
 *
 */
