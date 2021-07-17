package offer19_IsMatch;

/**
 * @Author WangBei
 * @Date 2021/7/13 12:29
 * @Description: 题目：请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 * ，无连续的 '*'。
 */


public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        for (int i = 2; i < p.length() + 1; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '*') {           // 当 p[j-1] = '*' 时，(此时需要考虑 p[j-2]出现 0 次和多次的情况)
                    if (dp[i][j - 2]) {                 // 出现 0 次，只需判断 dp[i][j-2] 的值，此时 dp[i][j] = dp[i][j-2]
                        dp[i][j] = true;
                    }
                    // 出现多次，判断多次是出现的 p 的字符和 s 的字符是否相等 (这里需要好好理解)
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {
                        // 这里为什么是dp[i-1][j],好好想想吧
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {
                        dp[i][j] = true;
                    }
                } else {                            // 当 p[j-1] != '*' 时，只需判断当前位是否匹配(字符相等或者为'.')
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}


/**
 * 思路：动态规划
 * 1、状态定义：dp[i][j]： s 的前 i 个字符与 p 的前 j 个字符是否匹配。
 * 2、转移方程：dp[i][j]表示添加的字符是 s[i-1] 和 p[j-1]
 * ··以下情况 dp[i][j]=true ,其余情况 = false
 * ···(1) 当 p[j-1] = '*' 时，(此时需要考虑 p[j-2]出现 0 次和多次的情况)
 * ······a. 出现 0 次，只需判断 dp[i][j-2] 的值，此时 dp[i][j] = dp[i][j-2]
 * ······b. 出现多次，判断多次是出现的 p 的字符和 s 的字符是否相等 (这里需要好好理解)
 * ········b.1. dp[i-1][j]==true && s[i-1]==p[i-2] 时, dp[i][j]=true
 * ········b.2. dp[i-1][j]==true && p[i-2]=='.' 时, dp[i][j]=true
 * ···(2) 当 p[j-1] != '*' 时，只需判断当前位是否匹配
 * ······a. dp[i-1][j-1]==true && s[i-1]==p[i-1]
 * ······b. dp[i-1][j-1]==true && p[i-1]=='.'
 */


/*
// 有问题的代码，其中考虑到了部分，无法判断例如 a*a 与 aa 的情况
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s != null && s.length() != 0) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                boolean next = false;
                while (!next) {
                    if (j >= p.length()) return false;
                    if (p.charAt(j) == ch || p.charAt(j) == '.') {
                        next = true;
                        j++;
                    } else if (p.charAt(j) == '*' && j > 0) {
                        if (p.charAt(j - 1) == ch || p.charAt(j - 1) == '.') {
                            next = true;
                        } else {
                            j++;
                        }
                    } else {
                        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                            j += 2;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (j >= p.length()) {
                return true;
            } else if (j == p.length() - 1 && p.charAt(j) == '*') {
                return true;
            }
            return false;
        }
        if (p.charAt(0) == '*' || p.charAt(1) == '*') return true;
        return false;
    }
}
*/























