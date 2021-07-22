package Interview17_14_SmallestK;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:36
 * @Description:
 */
public class Solution {
    int[] arr;

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0 || arr.length < k) return new int[0];
        this.arr = arr;
        int[] res = new int[k];
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
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
