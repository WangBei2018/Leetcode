package LeetCode5_longestPalindrome;

import org.omg.CORBA.MARSHAL;

/**
 * @Author WangBei
 * @Date 2021/8/27 10:02
 * @Description:
 */

// 中心扩散法
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 0;
        int index = 0;
        // 不需要比到最后一个字符，因为最后一个字符不能向右扩散，而从0开始是因为，可能不存在长度大于1的回文子串，所以返回第一个字符，
        // 当字符串长度为2时，并且两个字符不一样时，如果for循环从1开始，那么就不会走下面的循环，导致最终返回空字符串。
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = isPalindrome(s, i, i);
            int len2 = isPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                index = i - (maxLen - 1) / 2;   // 不管是奇数还是偶数都可以这样计算，自己可以在草稿纸上验算一下
            }
        }
        return s.substring(index, index + maxLen);
    }

    public int isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            } else {
                break;
            }
        }
        return right - left - 1;    // (right - 1) - (left + 1) + 1，不相等的时候前一个循环中 right 和 left 已经变化了
    }
}

/**
 * 思路：中心扩散法：从字符串的中心开始，依次向两边开始扩散，
 * 1、所以从字符串的第一个字符开始，依次计算以当前字符为中心进行扩散的字符串长度（分为奇数和偶数的情况）
 * 2、只需要记录最大长度以及字符串起始的位置即可。
 */
