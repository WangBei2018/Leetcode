package LeetCode5_longestPalindrome;

/**
 * @Author WangBei
 * @Date 2021/8/27 10:05
 * @Description:
 */

// 动态规划
public class Solution3 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int index = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if ((j - 1) - (i + 1) + 1 > 1) {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] == true && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    index = i;
                }

                // 简化
//                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] || ((j - 1) - (i + 1) + 1 < 2));
//                if (dp[i][j] == true && (j - i + 1) > maxLen) {
//                    maxLen = j - i + 1;
//                    index = i;
//                }
            }
        }
        return s.substring(index, index + maxLen);
    }
}


/**
 * 思路：动态规划
 * dp[i][j] 表示 s[i] 到 s[j] 子串是否为回文串。（j > i）
 * 1. 如果s[i] == s[j]
 * ```1.1 此时如果：(j-1) - (i+1) + 1 > 1 ，说明 s[i] 和 s[j] 中间有多个字符，那么如果 dp[i+1][j-1] == true，那么 s[i] 到 s[j] 就是回文串。
 * ···1.2 否则，说明 s[i] 和 s[j] 中间至多只有一个字符，此时只要 s[i] == s[j]，那么 s[i] 到 s[j] 就是回文串。
 * 2. 如果s[i] != s[j]，那么dp[i][j] = false
 * 所以 dp[i][j] = (s[i] == s[j]) && ( (j-1)-(i+1)+1 < 2 || dp[i+1][j-1])
 */