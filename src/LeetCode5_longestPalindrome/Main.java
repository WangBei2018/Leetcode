package LeetCode5_longestPalindrome;

import LeetCode1668_maxRepeating.Solution;

/**
 * @Author WangBei
 * @Date 2021/8/25 10:27
 * @Description: 最大回文子串
 */
public class Main {
    public static void main(String[] args) {
        String str = "ccabcdcbaa";

        Solution1 s = new Solution1();
        String palindrome1 = s.longestPalindrome(str);
        System.out.println(palindrome1);

        Solution2 s2 = new Solution2();
        String palindrome2 = s2.longestPalindrome(str);
        System.out.println(palindrome2);

        Solution3 s3 = new Solution3();
        String palindrome3 = s3.longestPalindrome(str);
        System.out.println(palindrome3);
    }
}
