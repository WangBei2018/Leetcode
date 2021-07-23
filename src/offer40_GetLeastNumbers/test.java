package offer40_GetLeastNumbers;


/**
 * @Author WangBei
 * @Date 2021/7/23 9:13
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution_quickSort s = new Solution_quickSort();
        int[] arr = {48, 62, 35, 77, 55, 14, 35, 98};
        int k = 4;
        int[] leastNumbers = s.getLeastNumbers(arr, k);
        for (int num : leastNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        Solution_prioritiyQueue sp = new Solution_prioritiyQueue();
        int[] leastNumbers1 = sp.getLeastNumbers(arr, k);
        for (int num : leastNumbers1) {
            System.out.print(num + " ");
        }
    }
}
