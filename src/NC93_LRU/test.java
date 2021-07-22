package NC93_LRU;

/**
 * @Author WangBei
 * @Date 2021/7/21 10:25
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] operators = {{1, 1, 1}, {1, 2, 2,}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}, {2, 1}, {1, 1, 6}, {2, 1}};
        int k = 3;
        int[] lru = s.LRU(operators, k);
        for (int num : lru) {
            System.out.print(num + " ");
        }
    }
}
