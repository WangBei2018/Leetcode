package LeetCode1668_maxRepeating;

/**
 * @Author WangBei
 * @Date 2021/8/25 10:18
 * @Description: 1668. 最大重复子字符串
 * 给你一个字符串 sequence，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的重复值为 k 。
 * 单词 word 的最大重复值是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * 给你一个字符串 sequence和 word，请你返回最大重复值k 。
 * <p>
 * 示例 1：
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * <p>
 * 示例 2：
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * <p>
 * 示例 3：
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * <p>
 * 提示：
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int res = 0;
        while (sequence.contains(sb)) {
            res++;
            sb.append(word);
        }
        return res;

    }
}

/**
 * 思路：一次重复添加 word ，判断原序列中是否含有当前重复子串。、
 * 看了题解的。哎，字符串的题做的不好。要多加练习。
 *
 * 可以尝试 KMP 算法，KMP 算法还要学习
 */

//    int k = 0;
//    int len = 0;
//    int maxK = 0;
//        for (int i = 0; i < sequence.length(); i++) {
//        len = 0;
//        int t = i;
//        for (int j = 0; j < word.length(); j++) {
//        if (i < sequence.length() && sequence.charAt(i) == word.charAt(j)) {
//        len++;
//        i++;
//        } else {
//        break;
//        }
//        }
//        if (len == word.length()) {
//        k++;
//        i--;
//        if (k > maxK) {
//        maxK = k;
//        }
//        } else {
//        i = t;
//        k = 0;
//        }
//
//        }
//        return k;