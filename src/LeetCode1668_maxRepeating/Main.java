package LeetCode1668_maxRepeating;

/**
 * @Author WangBei
 * @Date 2021/8/25 10:18
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        int repeating = s.maxRepeating(sequence, word);
        System.out.println(repeating);
    }
}
