package Interview16_01_SwapNumbers;

/**
 * @Author WangBei
 * @Date 2021/7/21 9:52
 * @Description:
 */
public class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];       // 此时numbers[1]就等于numbers[0]
        numbers[0] = numbers[0] ^ numbers[1];       // 此时numbers[0]就等于numbers[1]
        return numbers;
    }
}
/**
 * 思路： 利用运算 a^b^a = a, 不论正负，异或运算都只是做了位运算，
 * 所以在第二次异或运算时numbers[1]已经等于numbers[0],第三次异或运算时numbers[0]就等于numbers[1]
 *
 * 不能使用加法，有可能两数相加造成溢出
 */
