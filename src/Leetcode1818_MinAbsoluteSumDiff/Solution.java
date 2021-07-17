package Leetcode1818_MinAbsoluteSumDiff;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author WangBei
 * @Date 2021/7/16 13:45
 * @Description: 题目：给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * |x| 定义为：
 * ···如果 x >= 0 ，值为 x ，或者
 * ···如果 x <= 0 ，值为 -x
 * <p>
 * 示例 1：
 * ···输出：3
 * ···解释：有两种可能的最优方案：
 * ···- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * ···- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * ···两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * <p>
 * 示例 2：
 * ···输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * ···输出：0
 * ···解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * <p>
 * 示例 3：
 * ···输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * ···输出：20
 * ···解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * ···绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * 提示：
 * ···n == nums1.length
 * ···n == nums2.length
 * ···1 <= n <= 105
 * ···1 <= nums1[i], nums2[i] <= 105
 */
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums1.length; i++) {
            // 首先计算两个数组的绝对差值和，注意：这里不能使用+=，因为%的优先级高于+，所以会导致溢出，是的最终计算结果错误
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
        }
        if (sum == 0) return 0;

        int[] sorted = new int[nums1.length];
        sorted = nums1.clone();
        Arrays.sort(sorted);
        int maxAlt = 0;

        for (int i = 0; i < nums1.length; i++) {

            // 查找与nums2当前整数绝对值之差最小的nums1中的数，
            // 1.当j < nums1.length的情况时，当前返回的下标对应的sorted元素大于nums2[i]，可能前一个数，即sorted[index-1]与nums2[i]的差值更小，所以也需要判断一下
            // 2.当nums1的所有元素的值都小于nums2[i],此时判断sorted[index-1]其实是多余的步骤。
            int index = binarySearch(sorted, nums2[i]);

            int diff = Math.abs(nums1[i] - nums2[i]) - Math.abs(sorted[index] - nums2[i]);
            maxAlt = Math.max(maxAlt, diff);

            int diffMinus = 0;
            if (index > 0) {
                diffMinus = Math.abs(nums1[i] - nums2[i]) - Math.abs(sorted[index - 1] - nums2[i]);
            }
            maxAlt = Math.max(maxAlt, diffMinus);
        }
        return (sum - maxAlt + mod) % mod;
    }

    public int binarySearch(int[] sorted, int target) {     // 二分查找与target值最接近的nums数组中的数
        int low = 0;
        int high = sorted.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (sorted[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
/** 思路：排序+二分查找
 *  1. 首先计算两个数组的绝对差值和，注意溢出的问题，+=会出问题，因为 % 的优先级大于 + ；
 *  2. 一次计算更换 nums1 每一位能够使得最大差值和减小的最大变化值，更换 nums1 当前位置的值肯定是尽可能与 nums2 当前的值越接近越好，这里使用而分查找；
 *  3. 计算更换后的差值变化，求差值变化的最大值；
 *  4. 最后返回原始差值和与变化值之差，并对mod取余，这里需要加上mod，因为在前面计算原始差值和的时候取余是的最后的 sum-maxAlt 可能小于 0 ，座椅需要加上mod。
 * */


// 思路：找到最大的差值，然后替换最大差值对应下标index在nums1中找到和nums2[index]插值最小的数替换nums1[index]的值，得到最小绝对差值
// 问题：在下面这个示例中会遇到问题，最大的差值出现在1和9，但是如果替换nums1的1为21时，反而茶只会变大。
// [1,28,21]
// [9,21,20]
// 输出：16
// 预期：9


//public class Solution {
//    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//
//        int maxDiff = Math.abs(nums1[0] - nums2[0]);        // 记录两个数组中差值的最大值
//        int index = 0;                                      // 差值最大值对应的下标
//        for (int i = 1; i < nums1.length; i++) {            // 找到最大值的绝对值之差，并记录最大差值和下标
//            if (Math.abs(nums1[i] - nums2[i]) > maxDiff) {
//                maxDiff = Math.abs(nums1[i] - nums2[i]);
//                index = i;
//            }
//        }
//
//        if (maxDiff == 0) return 0;     // 两个数组相等，不用替换元素。
//        int altIndex = 0;               // 替换元素的下标
//        int minDiff = Math.abs(nums2[index] - nums1[0]); // 需要偷换的元素替换为与只对应的nums2相差组小的元素
//        for (int i = 1; i < nums1.length; i++) {
//            if (Math.abs(nums2[index] - nums1[i]) < minDiff) {
//                minDiff = Math.abs(nums2[index] - nums1[i]);
//                altIndex = i;
//            }
//        }
//        nums1[index] = nums1[altIndex];
//
//        int sum = 0;
//        for (int i = 0; i < nums1.length; i++) {        // 计算最小绝对差值和
//            sum += Math.abs(nums1[i] - nums2[i]) % (Math.pow(10, 9) + 7);
//        }
//
//        return sum;
//    }
//}














