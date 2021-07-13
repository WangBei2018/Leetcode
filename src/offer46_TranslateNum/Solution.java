package offer46_TranslateNum;

/**
 * @Author WangBei
 * @Date 2021/7/11 11:46
 * @Description: 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 提示：
 * 0 <= num < 2^31
 */
class Solution {
    public int translateNum(int num) {
        if (num < 0) return 0;
        int a = 1;
        int b = 1;
        int c = 1;
        int y = num % 10;
        num /= 10;
        int x = num % 10;
        while (num != 0) {
            if ((x * 10 + y) >= 10 && (x * 10 + y) <= 25) {
                c = a + b;
            } else {
                c = a;
            }
            b = a;
            a = c;
            y = x;
            num /= 10;
            x = num % 10;
        }

        return a;
    }
}
/**
 * * 思路：动态规划
 * * num = x1 x2 x3 x4 ... xn , 翻译方案数量f(n)
 * x1 x2 x3 ... xn-1 , 翻译方案数量f(n-1)
 * x1 x2 x3 ... xn-2 , 翻译方案数量f(n-2)
 * * 当x2 x1可翻译时，f(n) = f(n-1) + f(n-2)
 * 当x2 x1不可翻译时,f(n) = f(n-1)
 * * 初始化：
 * f(0) = f(1) = 1;
 */