package NC140_MySort;

/**
 * @Author WangBei
 * @Date 2021/7/30 16:08
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 2, 3, 1, 4};
        int[] res = s.MySort(arr);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
