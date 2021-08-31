package LeetCode459_RepeatedSubstringPattern;

/**
 * @Author WangBei
 * @Date 2021/8/28 10:08
 * @Description: 459. 重复的子字符串
 * 题目：给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        if (s == null || s.length() < 2 || s.length() > 10000) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.length() % i != 0) {
                continue;
            }
            String str = s.substring(0, i);
            for (int j = i; j <= s.length() - i; j += i) {
                String substring = s.substring(j, j + i);
                if (!substring.equals(str)) {
                    break;
                }
                if (j == s.length() - i) {
                    return true;
                }
            }
        }
        return false;
    }
}
/**
 * 思路: 遍历 + 剪枝
 * 遍历整个字符串，假设从开始到当前位置 i 的字符是重复的子串，
 * 1、每次在判断是否重复前用字符串的长度对前 i 个字符串的长度取余，如果不能整除证明当前子串不可能是重复的子串
 * 2、否则每次截取 i+1 长度的子串，一旦与前 i+1 个字符组成的字符串不相等时，跳出循环，没必要往后比了
 * 3、最终如果截取到最后一个长为 i+1 子串仍然与前 i+1 个字符相等时，证明这个字符串是由一个子串重复多次构成。
 */