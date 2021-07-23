package Interview17_14_SmallestK;

import java.util.Arrays;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:36
 * @Description: 面试题 17.14. 最小K个数
 * 题目：设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Solution {

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0 || arr.length < k) return new int[0];

        quickSort(arr, 0, arr.length - 1);

//        int[] res = new int[k];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = arr[i];
//        }

        return Arrays.copyOf(arr, k);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start == end) return;
        int index = partition(arr, start, end);
        if (index > start) quickSort(arr, start, index - 1);
        if (index < end) quickSort(arr, index + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
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
 * 思路：快速排序 + 数组划分
 * 优化：快速排序 + 二分思想
 */