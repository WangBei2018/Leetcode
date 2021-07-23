package Interview17_14_SmallestK;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:36
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,2,1};
        int k = 2;
        int[] kList = s.smallestK(arr, k);
        for (int num : kList) {
            System.out.print(num + " ");
        }
    }
}
