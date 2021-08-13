package NC91_LIS;

/**
 * @Author WangBei
 * @Date 2021/8/11 17:05
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 8, 6, 4};
        int[] lis = s.LIS(arr);
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
