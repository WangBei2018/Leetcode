package NC140_MySort;

/**
 * @Author WangBei
 * @Date 2021/7/30 16:07
 * @Description:
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // write code here
        quickSort(arr, 0, arr.length - 1);
        return arr;
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
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
            } else if (arr[start] > arr[end] && arr[end] == num) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
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