package offer10_II_NumWays;

/**
 * @Author WangBei
 * @Date 2021/6/17 20:43
 * @Description: 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 *      输入：n = 2
 *      输出：2
 * 示例 2：
 *      输入：n = 7
 *      输出：21
 * 示例 3：
 *      输入：n = 0
 *      输出：1
 * 提示：
 *      0 <= n <= 100
 * 思路：
 *      与求解斐波那契数列相同的思路，青蛙跳n个台阶的次数 = 跳 n-1 个台阶次数 + 跳 n-2 个台阶次数
 *      知道分解到跳 0 个台阶或跳 1 个台阶是，需要的次数 = 1
 */
public class Solution {
    public int numWays(int n) {
        if (n < 2) return 1;
        int num = 0;
        int num_1 = 1;
        int num_2 = 1;

        for (int i = 2; i <= n; i++) {
            num = (num_1 + num_2) % 1000000007;
            num_2 = num_1;
            num_1 = num;
        }
        return num;
    }
}
