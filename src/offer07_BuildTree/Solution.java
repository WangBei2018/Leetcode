package offer07_BuildTree;

import GetNext_20210611.Tree;

import java.util.HashMap;

/**
 * @Author WangBei
 * @Date 2021/6/10 9:03
 */

/*
题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
    返回如下的二叉树：
                    3
                   / \
                  9  20
                    /  \
                   15   7
限制：
    0 <= 节点个数 <= 5000
*/


/*思路：
    1.将中序遍历存入HashMap<中序遍历值，索引>；
    2.根据前序遍历找根节点，然后通过HashMap找到根节点在中序遍历中的位置i；
        所以在递归的时候的第一个参数root的值其实是当前子树的root在前序遍历中的索引
    3.通过根节点在中序遍历中的位置i找到中序遍历中左右子树的左右端点在中序遍历中的索引；
        所以在递归的时候左右端点的值是在中序遍历时的索引
*/


//public class Solution {
//    HashMap<Integer, Integer> hm;
//    int[] preorder;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        hm=new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            hm.put(inorder[i], i);
//        }
//
//        this.preorder = preorder;       // 首先需要初始化类中的变量，在递归函数中使用是才能找到值
//
//        TreeNode root = recur(0, 0, inorder.length-1);
//        return root;
//    }
//
//    public TreeNode recur(int root, int left, int right) {
//        if (left > right) return null;
//
//        TreeNode node = new TreeNode(preorder[root]);
//        int index = hm.get(preorder[root]);                 // 这里需要找到根节点在中序遍历中的位置，划分左右子树
//
//        node.left = recur(root + 1, left, index - 1);
//        node.right = recur(root + index - 1 - left + 2, index + 1, right);
//
//        return node;
//    }
//}


class Solution {
    HashMap<Integer, Integer> hm;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        TreeNode root = new TreeNode(0);
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        root = rebuildTree(0, 0, preorder.length - 1);
        return root;
    }

    public TreeNode rebuildTree(int root, int start, int end) {
        if (start > end) return null;

        TreeNode node = new TreeNode(preorder[root]);
        int index = hm.get(preorder[root]);
        node.left = rebuildTree(root + 1, start, index - 1);
        node.right = rebuildTree(root + index - start + 1, index + 1, end);
        return node;
    }
}