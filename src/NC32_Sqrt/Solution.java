package NC32_Sqrt;


/**
 * @Author WangBei
 * @Date 2021/7/24 13:46
 * @Description:
 */
public class Solution {
    public int sqrt(int x) {
        // write code here
        int low = 1;
        int high = x;
        int mid = (low + high) / 2;

        while (low < high) {
            if (Math.pow(mid, 2) == x) {
                return mid;
            } else if (Math.pow(mid, 2) > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (high + low) / 2;
        }
        if (Math.pow(low, 2) > x) return low - 1;
        return low;
    }
}
/**
 * 思路：二分查找
 * 二分查找，从 1 ~ x 判断当前中点的 2 次方
 * （1）当前中点的 2 次方 = x，直接返回中点的数字
 * （2）当前中点的 2 次方 > x，范围缩小到前一半
 * （3）当前中点的 2 次方 < x， 范围缩小到后一半
 */