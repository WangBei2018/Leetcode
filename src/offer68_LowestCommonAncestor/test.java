package offer68_LowestCommonAncestor;

/**
 * @Author WangBei
 * @Date 2021/7/24 10:22
 * @Description:
 */
public class test {
    static TreeNode p = new TreeNode(0);
    static TreeNode q = new TreeNode(0);

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] rootarr = {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5};
        TreeNode root = new TreeNode(rootarr[0]);
        createTree(root);
        TreeNode parent = s.lowestCommonAncestor(root, p, q);
        System.out.println(parent.val);
    }

    public static void createTree(TreeNode root) {

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        p = node2;
        q = node5;

        root.left = node2;
        root.right = node9;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;


    }
}
