package MaxKNode_20210323;

import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;

        node2.left = null;
        node2.right = node4;

        node3.left = null;
        node3.right = null;

        node4.left = null;
        node4.right = null;

        Solution s = new Solution();
//        printTree(node1);


        int k = 1;
        s.kthLargest(node1,k);

    }
}
