package offer60_DicesProbability;

import java.util.PropertyResourceBundle;

/**
 * @Author WangBei
 * @Date 2021/7/7 9:55
 * @Description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 * 示例2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * 1 <= n <= 11
 * <p>
 * 题解：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
 * dp[n][j]= ∑ (i=1~6) dp[n−1][j−i]
 */
//public class Solution {
//    public double[] dicesProbability(int n) {
//
//        // 递推公式：dp[n][j]= ∑ (i=1~6) dp[n−1][j−i]    dp[n][j]表示n个骰子，和为j出现的次数
//        // 使用一位数组表示中间过程，即把上面的二维数组拉平，最终的概率是数组第 n-1 ~ end 的取值除以总次数
//        int length = n * 6;
//        double[] probability = new double[length];
//        for (int i = 0; i < 6; i++) {
//            probability[i] = 1;
//        }
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 6 * i - 1; j >= i - 1; j--) {  // 从当前 i 个骰子能取到的最大总和开始，逐个向前求解直到和为i，下标为i-1 时每种情况出现的次数
//                probability[j] = 0;
//                for (int cur = 1; cur <= 6; cur++) {    // 第 i 个骰子取值为 1~6 时
//                    if (j - cur >= i - 2) {             // i-2表示的是在有n-1个骰子的时候起始的数字的下标
//                        probability[j] += probability[j - cur];
//                    }
//                }
//            }
//        }
//
//        // 出现的次数除以总次数，计算概率
//        double all = Math.pow(6, n);
//        double[] res = new double[n * 6 - n + 1];
//        for (int i = n - 1; i < probability.length; i++) {
//            res[i - n + 1] = probability[i] / all;
//        }
//        return res;
//    }
//}
public class Solution {
    public double[] dicesProbability(int n) {
        double[] probability = new double[n * 6];

        for (int i = 0; i < 6; i++) {
            probability[i] = 1.0 / 6;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i * 6 - 1; j >= i - 1; j--) {
                probability[j] = 0;
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur >= i - 2) {
                        probability[j] += probability[j - cur] * 1.0 / 6;
                    }
                }
            }
        }
        double[] res = new double[n * 6 - n + 1];
        for (int i = n - 1; i < probability.length; i++) {
            res[i - n + 1] = probability[i];
        }

        return res;
    }
}