package NC45_TreeOrders;

/**
 * @Author WangBei
 * @Date 2021/8/10 15:49
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        int[][] threeOrders = s.threeOrders(node1);

        for (int[] res : threeOrders) {
            for (int num : res) {
                System.out.print(num + " ");
            }
            System.out.println();
        }


    }
}
