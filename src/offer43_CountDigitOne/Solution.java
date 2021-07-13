package offer43_CountDigitOne;

/**
 * @Author WangBei
 * @Date 2021/7/7 20:42
 * @Description: 题目：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * <p>
 * 限制：
 * 1 <= n < 2^31
 */
public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        int digit = 1;

        while (high != 0 || cur != 0) {
            if (cur == 0) {         // 当 cur = 0 时，当前位 1 出现的次数 = high * digit;
                count += high * digit;
            } else if (cur == 1) {  // 当 cur = 1 时，当前位 1 出现的次数 = high * digit + low + 1;
                count += high * digit + low + 1;
            } else {                // 当 cur = 2~9 时，当前位 1 出现的次数 = (high + 1) * digit;
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
/**
 * 题解：计算每一位 1 出现的次数
 * 将n划分为 high+cur+low ，digit表示当前位因子 n = high*digit*10 + cur*digit + low;
 * 1.当 cur = 0 时，当前位 1 出现的次数 = high * digit;
 * 2.当 cur = 1 时，当前位 1 出现的次数 = high * digit + low + 1;
 * 3.当 cur = 2~9 时，当前位 1 出现的次数 = (high + 1) * digit;
 *
 * 举例：n = 2109
 * 初始状态： high = 210, cur = 9, low = 0, digit = 1, count = 0;
 * 1.当前位 cur = 9，所以当前位 1 出现的范围是：0001 ~ 2101 一共是 211 = 210 + 1 = (210 + 1) * 1 = (high + 1) * digit;
 *   此时更新各个参数的值，
 *      low = 9 = low + cur * digit;
 *      cur = 0 = high % 10;
 *      high = 21 = 210 / 10, 即 high/=10;
 *      digit = 10 = digit * 10;
 * 2.当前位 cur = 0，所以当前位 1 出现的范围是：0010 ~ 2019 一共是 210 = 21 * digit = high * digit;
 *   更新参数的值: low = 09, cur = 1, high = 2, digit = 100;
 * 3.当前位 cur = 1，所以当前位 1 出现的范围是：0100 ~ 2109 一共是 210 = 2 * 100 + 9 + 1 = high * digit + low + 1;
 *   更新参数的值： low = 109, cur = 2, high = 0, digit = 1000;
 * 4.当前位 cur = 2，所以当前位 1 出现的范围是：1000 ~ 1999 一共是 1000 = (0 + 1) * 1000 = (high + 1) * digit;
 *   更新参数的值： low = 2109, cur = 0, high = 0, digit = 10000;
 * 5.结束循环
 */
