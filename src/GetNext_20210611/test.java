package GetNext_20210611;

/**
 * @Author WangBei
 * @Date 2021/6/11 11:31
 */
/*
题目：给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右节点的指针，还有一个指向父节点的指针

思路：
    若一个节点有右子树，则下一个节点就是右子树的最左子节点
    若一个几点没有右子树，
        这个节点是他父节点的左子树，则下一个节点是他的父节点
        这个节点是他父节点的右子树，则下一个节点是沿着父节点的方向，知道找到一个节点是他父节点的左节点，则下一个节点是这个节点的父节点。
*/


public class test {
    public static void main(String[] args) {
        Solution s = new Solution();

        Tree tree = new Tree();

        TreeNode next = s.getNext(tree.nodeB);
        if(next!=null){
            System.out.println(next.val);
        }else {
            System.out.println("null");
        }
    }


}
