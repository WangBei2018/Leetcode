package LeetCode459_RepeatedSubstringPattern;

/**
 * @Author WangBei
 * @Date 2021/8/28 10:08
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcabcabcabc";
        boolean isRepeated = s.repeatedSubstringPattern(str);
        System.out.println(isRepeated);
    }
}
