package Leetcode56_Merge;

/**
 * @Author WangBei
 * @Date 2021/7/22 13:50
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] merge = s.merge(intervals);
        for (int[] row : merge) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
