package Offer59_II_maxSlidingWindow;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
