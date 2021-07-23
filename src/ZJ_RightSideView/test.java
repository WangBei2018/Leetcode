package ZJ_RightSideView;

import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/23 16:36
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        List<Integer> list = s.rightSideView(preorder, inorder);
        for (int num : list) {
            System.out.println(num);
        }
    }
}
