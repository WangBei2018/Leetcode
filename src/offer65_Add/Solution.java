package offer65_Add;

/**
 * @Author WangBei
 * @Date 2021/6/30 10:10
 * @Description:题目：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 */

// 对a，b两个数做加法时，进位 c = (a & b) << 1，当前位 d = a ^ b.所以a + b = c + d
public class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
