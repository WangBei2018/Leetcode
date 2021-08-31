package NC127_LCS;

/**
 * @Author WangBei
 * @Date 2021/8/20 10:39
 * @Description: NC127 最长公共子串
 * 描述:给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * <p>
 * 示例1:
 * 输入："1AB2345CD","12345EF"
 * 返回值："2345"
 * <p>
 * 备注：1≤∣str1∣,∣str2∣≤5000
 */
public class Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int maxLen = 0;
        int index = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        index = j - 1;
                    }
                }
            }
        }
        return str2.substring(index - maxLen + 1, index + 1);       // subString 区间前闭后开
    }
}

/**
 * 思路：动态规划
 * 如果当前字符相等：dp[i][j] = dp[i-1][j-1] + 1 , 并且记录最大程度以及对应的子串最后一位字符的下标
 * 如果不相等：dp[i][j] = 0
 */