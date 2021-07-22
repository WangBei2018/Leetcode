package Interview16_01_SwapNumbers;

/**
 * @Author WangBei
 * @Date 2021/7/21 9:52
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1, 2};
        s.swapNumbers(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
