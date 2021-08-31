package LeetCode1143_LongestCommonSubsequence;

/**
 * @Author WangBei
 * @Date 2021/8/28 11:10
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String text1 = "mhunuzqrkzsnidwbun";
        String text2 = "szulspmhwpazoxijwbq";

        int length = s.longestCommonSubsequence(text1, text2);
        System.out.println(length);
    }
}




