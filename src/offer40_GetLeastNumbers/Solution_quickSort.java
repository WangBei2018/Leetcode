package offer40_GetLeastNumbers;

import java.util.Arrays;

/**
 * @Author WangBei
 * @Date 2021/7/23 9:13
 * @Description: 剑指 Offer 40. 最小的k个数 ------ 同 面试题 17.14
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 */
public class Solution_quickSort {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        if (arr.length <= k) return arr;
        quickSort(arr, 0, arr.length - 1, k - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int start, int end, int k) {
        if (start == end) return;

        int index = partition(arr, start, end);
        if (index == k) return;
        if (index > k) quickSort(arr, start, index - 1, k);
        if (index < k && index < end) quickSort(arr, index + 1, end, k);
    }

    private int partition(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end > arr.length - 1) return -1;
        int num = arr[start];
        while (start < end) {
            if (arr[start] > arr[end] && arr[start] == num) {
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                start++;
            } else if (arr[start] > arr[end] && arr[end] == num) {
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                end--;
            } else if (arr[start] == num) {
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}

/**
 *
 */