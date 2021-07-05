package offer04_FindNumberIn2DArray;

/**
 * @Author WangBei
 * @Date 2021/6/9 8:44
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int target = 5;
        int[][] matrix = {};
        int target = 0;

        boolean found = s.findNumberIn2DArray(matrix, target);
        System.out.println(found);
    }
}
