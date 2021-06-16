package GetNext_20210611;


/**
 * @Author WangBei
 * @Date 2021/6/11 11:27
 */
public class Solution {
    public TreeNode getNext(TreeNode node) {
        TreeNode next;
        TreeNode tn = node;
        while (tn != null) {
            if (node.right != null) {           // 右子树不为空
                TreeNode tnright = node.right;
                while (tnright.left != null) {
                    tnright = tnright.left;
                }
                return tnright;
            } else if (node.parent != null && node == node.parent.left) {   // 查找的节点是他父节点的左子树
                return node.parent;
            } else {                            // 查找的节点是他父节点的右子树
                TreeNode tnparent = node.parent;
                while (tnparent != null && tnparent.parent != null && tnparent != tnparent.parent.left) {
                    tnparent = tnparent.parent;
                }
                if (tnparent != null) return tnparent.parent;
                return null;
            }
        }

        return null;
    }

//    public void inorder(TreeNode node) {
//        if (node == null) return;
//
//        if (node.left != null) inorder(node.left);
//        System.out.print(node.val + " ");
//        if (node.right != null) inorder(node.right);
//    }
}
