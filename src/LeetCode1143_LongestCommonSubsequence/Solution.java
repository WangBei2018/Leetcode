package LeetCode1143_LongestCommonSubsequence;

/**
 * @Author WangBei
 * @Date 2021/8/28 11:10
 * @Description: 1143. 最长公共子序列
 * 题目：给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }
}
/**
 * 思路：动态规划
 * <p>
 * 分析：要想计算两个字符串的最长公共子序列，即 text1前 n 个和 text2 前 m 个字符中最长的子序列，
 * 子问题就是 text1 和 text2 前 n-1 和 m-1 个字符最长公共子序列长度。
 * <p>
 * 状态转移方程：
 * 1. 当 text1[i] == text2[j] 时，dp[i][j] = dp[i-1][j-1] + 1;
 * 2. 当 text1[i] != text2[j] 时，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
 * 3. 最终返回 dp[text1.length()][text2.lenghth()];
 * 注：初始化时需要多一维保证边界情况时不会出现越界的问题。
 */

//public class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len = 0;
//        int lastIndex;
//        int maxlen = 0;
//
//        if (text1.length() < text2.length()) {
//            String temp = text1;
//            text1 = text2;
//            text2 = temp;
//        }
//
//        for (int i = 0; i < text1.length() - maxlen; i++) {
//            if (text1.contains(text2)) {
//                return text2.length();
//            }
//            String str = text1.charAt(i) + "";
//            if (text2.contains(str)) {
//                len = 1;
//                if (len > maxlen) {
//                    maxlen = len;
//                }
//                lastIndex = i;
//                for (int j = text2.indexOf(str) + 1; j < text2.length(); j++) {
//                    String temp = text1.substring(lastIndex + 1, text1.length());
//                    if (temp.contains(text2.charAt(j) + "")) {
//                        lastIndex += temp.indexOf(text2.charAt(j)) + 1;
//                        len++;
//                        if (len > maxlen) {
//                            maxlen = len;
//                        }
//
//                    }
//                }
//            }
//        }
//        return maxlen;
//    }
//}
