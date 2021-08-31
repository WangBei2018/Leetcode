package LeetCode5_longestPalindrome;

/**
 * @Author WangBei
 * @Date 2021/8/25 10:27
 * @Description: 5. 最长回文子串
 * 题目：给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int index = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // j - i + 1 > maxLen进行剪枝，一次判断子串是不是回文串，如果是记录起点坐标和最大长度
                if (j - i + 1 > maxLen && isPalindrom(s.substring(i, j + 1))) {
                    index = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(index, index + maxLen);      // 前闭后开
    }

    public boolean isPalindrom(String s) {          // 判断当前子串是不是回文串
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/**
 * 思路：暴力解法
 * 双重循环，暴力遍历字符串，依次判断子串是不是回文串，可以在判断前通过长度与最大长度比较，就可以省去一些无谓的比较。
 */
