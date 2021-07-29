package NC102_lowestCommonAncestor;


/**
 * @Author WangBei
 * @Date 2021/7/24 10:58
 * @Description:
 */
public class test {


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        createTree(root);
        int p = 5;
        int q = 4;
        int common = s.lowestCommonAncestor(root, p, q);
        System.out.println(common);
    }

    public static void createTree(TreeNode root) {

        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);


        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

    }
}
