package Leetcode1846_MaximumElementAfterDecrementingAndRearranging;

import java.util.Arrays;

/**
 * @Author WangBei
 * @Date 2021/7/17 11:46
 * @Description:
 */
// 解法一：排序 + 贪心
//public class Solution {
//    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//        Arrays.sort(arr);
//        arr[0] = 1;
//        for (int i = 1; i < arr.length; i++) {
//            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
//        }
//        return arr[arr.length - 1];
//    }
//}

/**
 * 思路：
 * ···1. 对原数组排序
 * ···2. 遍历数组，将排序后的数组的每一位与前一位 +1 比较，取较小的值，保证每位之间的差的绝对值小于等于1
 * ···3. 最终改变完的数组的最后一位是能取到的最大值
 */

// 解法二：计数 + 贪心
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];
        for (int num : arr) {
            if (num > n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }

        int miss = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                miss++;
            } else {
                miss = miss - Math.min(miss, count[i] - 1);
            }
        }
        return n - miss;
    }
}
/**
 * 思路: miss: 1 ~ n 中空缺位个数
 * ···1. 对 arr 数组中出现的每一个数字进行计数
 * ···2. 遍历计数数组，
 * ·····2.1. 若当前位 arr[i]=0，即没有数字时，则此位空缺，miss++
 * ·····2.2. 若当前位 arr[i]!=0，即当前位有数字，则使用当前位填补前面的空缺以及当前位，最多填补完前面所有的空缺和本身，所以miss减少的值取 miss 和 arr[i]-1 中较小的
 * ···3. 最终计算出所有的空缺位，能取到的最大值就是 n - miss
 */