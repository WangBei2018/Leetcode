package MaxKNode_20210323;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;

public class Solution {
    int k,res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root,k);
        return res;
    }

    void dfs(TreeNode root, int k){
        if(root == null) return;
        if(k == 0) {
            res = root.val;
            return;
        }
        System.out.println(root.val+", "+k);
        dfs(root.right,k-1);
        k -= 1;
        dfs(root.left,k);
    }

    void printTree(TreeNode root){
        if (root == null) return;


        printTree(root.left);
        printTree(root.right);
        System.out.println(root.val);
    }

}
