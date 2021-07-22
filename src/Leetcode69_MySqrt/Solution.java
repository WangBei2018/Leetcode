package Leetcode69_MySqrt;

/**
 * @Author WangBei
 * @Date 2021/7/22 13:31
 * @Description:
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 0) return 0;
        int high = x;
        int low = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            if (Math.pow(mid, 2) > x) {
                high = mid - 1;
            } else if (Math.pow(mid, 2) < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        if (Math.pow(low, 2) > x) {
            return low - 1;
        }
        return low;
    }
}
